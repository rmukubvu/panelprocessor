package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PanelRequestMessage {
    private String panelSerialNumber;
    private String panelAddress;
    private Integer panelPort;
    private Integer controllerAddress;
    private Integer modbusFunction;
    private Integer registerAddress;
    private Integer numberOfRegisters;
    private Integer cRCLsbFirst;

    public void validator() {
        if (this.numberOfRegisters > 22) {
            throw new RuntimeException("Max readable registers is 22");
        }
    }

    @Override
    public String toString() {
        return String.format("%02X%s%02X%04XE116" , controllerAddress, ModbusFunctionCode.byCodeToHex(modbusFunction),
                registerAddress,
                numberOfRegisters);
    }
}
