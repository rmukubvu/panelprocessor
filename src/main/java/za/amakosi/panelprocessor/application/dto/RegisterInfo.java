package za.amakosi.panelprocessor.application.dto;

import lombok.Data;

@Data
public class RegisterInfo {
    private Integer address;
    private Integer registerSize;
    private String unit;
    private String friendlyName;
}
