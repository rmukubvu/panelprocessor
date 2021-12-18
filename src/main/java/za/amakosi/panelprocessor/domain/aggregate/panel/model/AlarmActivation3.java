package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum AlarmActivation3 implements Alarm<AlarmActivation3> {

    ALARM_0(0, "Faulty Pressure Transducer"),
    ALARM_1(1, "Weekly Test Required"),
    ALARM_2(2, "Cooling No Flow"),
    ALARM_3(3, "Engine Fail When Running"),
    ALARM_4(4, "Engine Fail to Start"),
    ALARM_5(5, "Engine Overspeed"),
    ALARM_6(6, "I/O Diesel Board Comm Loss"),
    ALARM_7(7, "I/O Expansion 1 Comm Loss"),
    ALARM_8(8, "I/O Expansion 2 Comm Loss"),
    ALARM_9(9, "I/O Expansion 3 Comm Loss"),
    ALARM_10(10, "Engine Pickup 1 Fail"),
    ALARM_11(11, "Engine Pickup 2 Fail"),
    ALARM_12(12, "Low Ambient Temperature"),
    ALARM_13(13, "Engine Run"),
    ALARM_14(14, "CANBUS Comm Systems Failure"),
    ALARM_15(15, "Pump on Demand");

    private final Integer alarm;
    private final String description;

    @Override
    public String byAlarm(Integer alarm) {
        var result = Arrays.stream(AlarmActivation3.values()).filter(e -> e.alarm.equals(alarm)).findFirst().orElse(null);
        return Optional.ofNullable(result).isPresent() ? result.description : null;
    }
}
