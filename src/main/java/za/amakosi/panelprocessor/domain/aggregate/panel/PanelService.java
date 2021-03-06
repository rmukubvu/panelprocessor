package za.amakosi.panelprocessor.domain.aggregate.panel;

import org.springframework.stereotype.Service;
import za.amakosi.panelprocessor.domain.aggregate.panel.model.*;
import za.amakosi.panelprocessor.domain.aggregate.panel.tcp.PanelTCPClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

@Service
public class PanelService {

    public List<ResponseMessage> queryPanel(PanelRequestMessage panelRequestMessage) {
        panelRequestMessage.validator();
        var client = new PanelTCPClient();
        client.openConnection(panelRequestMessage.getPanelAddress(), panelRequestMessage.getPanelPort());
        var response = client.sendMessage(panelRequestMessage.toString());
        client.closeConnection();
        var panelResponseMessage = PanelResponseMessage.valueOf(response);
        return buildResponse(panelRequestMessage, panelResponseMessage);
    }

    public List<RegisterInfo> registerInfo() {
        return List.of(Register.values()).stream().map( register -> RegisterInfo.builder()
                .address(register.getAddress())
                .registerSize(register.getRegisterSize())
                .friendlyName(register.getFriendlyName())
                .unit(register.getUnit())
                .build()).collect(Collectors.toList());
    }

    private List<ResponseMessage> buildResponse(PanelRequestMessage panelRequestMessage,PanelResponseMessage panelResponseMessage) {
        List<ResponseMessage> responseMessages = new ArrayList<>();
        IntStream.range(0, panelRequestMessage.getNumberOfRegisters()).forEachOrdered(i -> {
            int registerAddress = panelRequestMessage.getRegisterAddress() + i;
            var registerInfo = Register.byAddress(registerAddress);
            var hexRegisterValue = panelResponseMessage.getRegisterHexValues().get(i);
            responseMessages.add(ResponseMessage.builder()
                    .label(registerInfo.getFriendlyName())
                    .value(getValueTextFor(registerAddress, hexRegisterValue))
                    .unitOfMeasure(registerInfo.getUnit())
                    .valueText(getFormattedValueTextFor(registerAddress, registerInfo, hexRegisterValue))
                    .build());
        });
        return responseMessages;
    }


    private String getValueTextFor(Integer registerAddress,String hexRegisterValue ) {
        final int RADIX = 16;
        final int CONTROLLER_INFORMATION_ADDRESS_NOT_IN = 41001;
        if (registerAddress < CONTROLLER_INFORMATION_ADDRESS_NOT_IN) {
            return hexRegisterValue;
        }
        //check if it's an alarm
        var intValue = parseInt(hexRegisterValue, RADIX);
        Optional<String> alarmCode = AlarmFactory.getAlarmCode(registerAddress, intValue);
        return alarmCode.orElseGet(() -> String.format("%d", intValue));
    }

    private String getFormattedValueTextFor(Integer registerAddress,Register registerInfo , String hexRegisterValue ) {
        final int CONTROLLER_INFORMATION_ADDRESS_NOT_IN = 41001;
        if (registerAddress < CONTROLLER_INFORMATION_ADDRESS_NOT_IN) {
            return hexRegisterValue;
        }
        //check if it's an alarm
        final int RADIX = 16;
        var intValue = parseInt(hexRegisterValue, RADIX);
        Optional<String> alarmCode = AlarmFactory.getAlarmCode(registerAddress, intValue);
        return alarmCode.orElseGet(() -> String.format("%d%s", intValue, registerInfo.getUnit()));
    }

    private String getLocalDateFrom(Integer date) {
        return null;
    }

    private String getLocalTimeFrom(Integer time) {
        return null;
    }
}
