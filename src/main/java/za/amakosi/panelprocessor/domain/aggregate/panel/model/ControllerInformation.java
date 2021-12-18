package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.Builder;


@Builder
public class ControllerInformation {
    private String serialNumber;
    private String packageName;
    private String model;
    private String softwareVersion;
    private double nominalVoltage;
    private double nominalCurrent;
}
