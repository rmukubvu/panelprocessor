package za.amakosi.panelprocessor.infrastructure.listener.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import za.amakosi.panelprocessor.domain.aggregate.panel.model.PanelResponseMessage;

import java.util.Optional;

@Service
@Slf4j
public class MessageProcessorService {

    public void processIncomingMessage(String message) {
        PanelResponseMessage panelResponseMessage = PanelResponseMessage.valueOf(message);
        if (Optional.of(panelResponseMessage.getError()).isPresent()) {
            //sort out errors
        }
        //continue here - confirm if panel sends us message without poking it
    }
}
