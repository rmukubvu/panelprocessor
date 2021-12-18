package za.amakosi.panelprocessor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.amakosi.panelprocessor.infrastructure.listener.PanelConsumer;

@Configuration
public class RabbitBean {

    @Bean
    public PanelConsumer panelConsumer() {
        return new PanelConsumer();
    }
}
