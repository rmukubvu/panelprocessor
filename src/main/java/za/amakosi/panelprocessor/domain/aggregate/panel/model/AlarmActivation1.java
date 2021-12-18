package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum AlarmActivation1 implements Alarm {

    ALARM_0(0, "AC Failure"),
    ALARM_1(1, "DC Failure"),
    ALARM_2(2, "Battery 1 Failure"),
    ALARM_3(3, "Battery 2 Failure"),
    ALARM_4(4, "Charger 1 Failure"),
    ALARM_5(5, "Charger 2 Failure"),
    ALARM_6(6, "Engine Trouble"),
    ALARM_7(7, "Pump Room Alarm"),
    ALARM_8(8, "Controller Trouble"),
    ALARM_9(9, "Service Required"),
    ALARM_10(10, "Weak Battery 1"),
    ALARM_11(11, "Weak Battery 2"),
    ALARM_12(12, "Loss of Continuity - Contactor 1"),
    ALARM_13(13, "Loss of Continuity - Contactor 2"),
    ALARM_14(14, "Weekly Test Cut-In Not Reached"),
    ALARM_15(15, "Weekly Test Check Solenoid Valves");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(AlarmActivation1.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
