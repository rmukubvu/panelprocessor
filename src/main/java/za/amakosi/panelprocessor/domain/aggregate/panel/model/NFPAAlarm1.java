package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum NFPAAlarm1 implements Alarm {

    ALARM_0 (0 , "Minimum Run Delay Timing High"),
    ALARM_1 (1 , "Not Used"),
    ALARM_2 (2 , "High Zone Delay Timing High"),
    ALARM_3 (3 , "Sequence Delay Timing High"),
    ALARM_4 (4 , "Load Shed Active High"),
    ALARM_5 (5 , "Not Used"),
    ALARM_6 (6 , "Low Suction Alarm High"),
    ALARM_7 (7 , "Low Suction Shutdown Active High"),
    ALARM_8 (8 , "System Over Pressure Alarm High"),
    ALARM_9 (9 , "Restart Delay Timing High"),
    ALARM_10(10, "Weekly Test Demand Active High"),
    ALARM_11(11, "Failure to Start Alarm High"),
    ALARM_12(12, "Lockout Active High"),
    ALARM_13(13, "Not Used"),
    ALARM_14(14, "Not Used"),
    ALARM_15(15, "Not Used");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(NFPAAlarm1.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}

