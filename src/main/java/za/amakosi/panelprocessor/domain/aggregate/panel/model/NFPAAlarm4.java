package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum NFPAAlarm4 implements Alarm {

    ALARM_0(0, "Pump Trouble #1 Input High"),
    ALARM_1(1, "Pump Trouble #2 Input High"),
    ALARM_2(2, "Pump Trouble #3 Input High"),
    ALARM_3(3, "Pump Trouble #4 Input High"),
    ALARM_4(4, "Pump Trouble #5 Input High"),
    ALARM_5(5, "Not Used"),
    ALARM_6(6, "Not Used"),
    ALARM_7(7, "Not Used"),
    ALARM_8(8, "Not Used"),
    ALARM_9(9, "Not Used"),
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
        var result = Arrays.stream(NFPAAlarm4.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
