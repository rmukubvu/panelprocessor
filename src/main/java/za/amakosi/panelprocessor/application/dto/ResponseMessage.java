package za.amakosi.panelprocessor.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage {
    private String label;
    private String value;
    private String unitOfMeasure;
    private String valueText;
}
