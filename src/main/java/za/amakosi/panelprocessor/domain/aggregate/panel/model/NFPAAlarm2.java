package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum NFPAAlarm2 implements Alarm {

    ALARM_0(0, "Pressure Star Demand High"),
    ALARM_1(1, "Remote Start Demand High"),
    ALARM_2(2, "Deluge Start Demand High"),
    ALARM_3(3, "Weekly Test Start Demand High"),
    ALARM_4(4, "Local Start PB Demand High"),
    ALARM_5(5, "Manual Operator Start Demand High"),
    ALARM_6(6, "Audible Alarm High"),
    ALARM_7(7, "Not Used"),
    ALARM_8(8, "Controller Trouble"),
    ALARM_9(9, "Load Shedding Delay Timing High"),
    ALARM_10(10, "Not Used"),
    ALARM_11(11, "Not Used"),
    ALARM_12(12, "Pressure Transducer Fault High"),
    ALARM_13(13, "Not Used"),
    ALARM_14(14, "Not Used"),
    ALARM_15(15, "Controller in Bypass Mode");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(NFPAAlarm2.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
