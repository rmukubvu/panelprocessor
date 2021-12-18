package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum InputStatus1 implements Alarm {

    ALARM_0(0, "Engine Run"),
    ALARM_1(1, "Engine Over speed"),
    ALARM_2(2, "Oil Pressure"),
    ALARM_3(3, "High Engine Water Temp"),
    ALARM_4(4, "Charger 1 OK"),
    ALARM_5(5, "Charger 2 OK"),
    ALARM_6(6, "Pump house Protection"),
    ALARM_7(7, "Low Fuel Level"),
    ALARM_8(8, "Panel Door"),
    ALARM_9(9, "Raw Water Flow"),
    ALARM_10(10, "Pressure Switch"),
    ALARM_11(11, "Pressure Switch Fault"),
    ALARM_12(12, "Lockout"),
    ALARM_13(13, "Remote Manual Start"),
    ALARM_14(14, ""),
    ALARM_15(15, "");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(InputStatus1.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
