package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum AlarmActivation3 implements Alarm<AlarmActivation3> {

    ALARM_0(0, "Invalid Cut-In"),
    ALARM_1(1, "Test Mode"),
    ALARM_2(2, "Pneumatic Failure to Start"),
    ALARM_3(3, "Auto-Mode Bypass"),
    ALARM_4(4, "Hydraulic Failure to Start"),
    ALARM_5(5, "Bell Silenced"),
    ALARM_6(6, "APS AD General Default"),
    ALARM_7(7, "Over pressure"),
    ALARM_8(8, "Under pressure"),
    ALARM_9(9, "Low Suction Pressure"),
    ALARM_10(10, "Flow Start"),
    ALARM_11(11, "Battery 1 Over voltage"),
    ALARM_12(12, "Battery 2 Over voltage"),
    ALARM_13(13, "High Ambient Temperature"),
    ALARM_14(14, "Not Used"),
    ALARM_15(15, "Low Raw Water Flow");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(AlarmActivation3.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
