package za.amakosi.panelprocessor.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanelRequestMessage {
    private String panelSerialNumber;
    private String panelAddress;
    private Integer panelPort;
    private Integer controllerAddress;
    private Integer modbusFunction;
    private Integer registerAddress;
    private Integer numberOfRegisters;
    private Integer cRCLsbFirst;
}
