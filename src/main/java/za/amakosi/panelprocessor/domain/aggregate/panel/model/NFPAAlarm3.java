package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum NFPAAlarm3 implements Alarm {

    ALARM_0(0, "Timed Trip Timing High"),
    ALARM_1(1, "Motor Running High"),
    ALARM_2(2, "Motor Overload Alarm High"),
    ALARM_3(3, "Not Used"),
    ALARM_4(4, "Phase Reversal Alarm High"),
    ALARM_5(5, "AC Voltage Low Alarm High"),
    ALARM_6(6, "Not Used"),
    ALARM_7(7, "Not Used"),
    ALARM_8(8, "Not Used"),
    ALARM_9(9, "AC Power Available High"),
    ALARM_10(10, "Not Used"),
    ALARM_11(11, "Not Used"),
    ALARM_12(12, "Not Used"),
    ALARM_13(13, "Not Used"),
    ALARM_14(14, "Not Used"),
    ALARM_15(15, "Not Used");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(NFPAAlarm3.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
