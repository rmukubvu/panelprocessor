package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum OutputStatus1 implements Alarm {

    ALARM_0(0, "Fuel Solenoid"),
    ALARM_1(1, "Cranking Battery 1"),
    ALARM_2(2, "Cranking Battery 2"),
    ALARM_3(3, "Stop Solenoid"),
    ALARM_4(4, "Drain Valve Solenoid"),
    ALARM_5(5, "Relay A"),
    ALARM_6(6, "Relay B"),
    ALARM_7(7, "Relay C"),
    ALARM_8(8, "Relay D"),
    ALARM_9(9, "Relay E"),
    ALARM_10(10, "Relay F"),
    ALARM_11(11, "Relay G"),
    ALARM_12(12, "Relay H"),
    ALARM_13(13, ""),
    ALARM_14(14, ""),
    ALARM_15(15, "");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(OutputStatus1.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
