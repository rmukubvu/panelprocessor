package za.amakosi.panelprocessor.infrastructure.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import za.amakosi.panelprocessor.infrastructure.listener.service.MessageProcessorService;

public class PanelConsumer {

    @Autowired
    private MessageProcessorService messageProcessorService;
    private static final String MY_QUEUE_NAME = "amakosi.panels.incoming.messages";

    @RabbitListener(queues = MY_QUEUE_NAME)
    public void listen(String message) {
        messageProcessorService.processIncomingMessage(message);
    }
}
