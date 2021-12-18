package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum AlarmActivation4 implements Alarm<AlarmActivation4> {

    ALARM_0(0, "Low Spare Temperature"),
    ALARM_1(1, "Water Reservoir Low"),
    ALARM_2(2, "Water Reservoir Empty"),
    ALARM_3(3, "Water Reservoir High"),
    ALARM_4(4, "Flow Meter On"),
    ALARM_5(5, "Fuel Tank Low"),
    ALARM_6(6, "Low Fuel Level"),
    ALARM_7(7, "High Fuel Level"),
    ALARM_8(8, "ECU in Alternate Position"),
    ALARM_9(9, "Fuel Injection Malfunction"),
    ALARM_10(10, "High Engine Temperature"),
    ALARM_11(11, "Engine Low Temperature"),
    ALARM_12(12, "ECU Module Warning"),
    ALARM_13(13, "ECU Module Fault"),
    ALARM_14(14, "Engine Low Oil Pressure"),
    ALARM_15(15, "Low Pneumatic Pressure");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(AlarmActivation4.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
