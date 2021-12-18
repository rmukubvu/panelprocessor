package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseMessage {
    private String label;
    private String valueText;
}
