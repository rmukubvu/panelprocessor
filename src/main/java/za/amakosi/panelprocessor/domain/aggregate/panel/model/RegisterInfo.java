package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterInfo {
    private Integer address;
    private Integer registerSize;
    private String unit;
    private String friendlyName;
}
