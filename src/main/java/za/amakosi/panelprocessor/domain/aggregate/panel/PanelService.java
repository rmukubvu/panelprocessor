package za.amakosi.panelprocessor.domain.aggregate.panel;

import org.springframework.stereotype.Service;
import za.amakosi.panelprocessor.domain.aggregate.panel.model.*;
import za.amakosi.panelprocessor.domain.aggregate.panel.tcp.PanelTCPClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

@Service
public class PanelService {

    public List<ResponseMessage> queryPanel(PanelRequestMessage panelRequestMessage) {
        panelRequestMessage.validator();
        var client = new PanelTCPClient();
        client.startConnection(panelRequestMessage.getPanelAddress(), panelRequestMessage.getPanelPort());
        var response = client.sendMessage(panelRequestMessage.toString());
        var panelResponseMessage = PanelResponseMessage.valueOf(response);
        return buildResponse(panelRequestMessage, panelResponseMessage);
    }

    private List<ResponseMessage> buildResponse(PanelRequestMessage panelRequestMessage,PanelResponseMessage panelResponseMessage) {
        List<ResponseMessage> responseMessages = new ArrayList<>();
        IntStream.range(0, panelRequestMessage.getNumberOfRegisters()).forEachOrdered(i -> {
            int registerAddress = panelRequestMessage.getRegisterAddress() + i;
            var registerInfo = Register.byAddress(registerAddress);
            var hexRegisterValue = panelResponseMessage.getRegisterHexValues().get(i);
            responseMessages.add(ResponseMessage.builder()
                    .label(registerInfo.getFriendlyName())
                    .valueText(getFormattedValueTextFor(registerAddress, registerInfo, hexRegisterValue))
                    .build());
        });
        return responseMessages;
    }

    private String getFormattedValueTextFor(Integer registerAddress,Register registerInfo , String hexRegisterValue ) {
        final int CONTROLLER_INFORMATION_ADDRESS_NOT_IN = 41001;
        final int RADIX = 16;
        if (registerAddress < CONTROLLER_INFORMATION_ADDRESS_NOT_IN) {
            return hexRegisterValue;
        }
        //check if it's an alarm
        var intValue = parseInt(hexRegisterValue, RADIX);
        Optional<String> alarmCode = AlarmFactory.getAlarmCode(registerAddress, intValue);
        return alarmCode.orElseGet(() -> String.format("%d %s", intValue, registerInfo.getUnit()));
    }
}
