package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AlarmFactory {

    static Map<Integer, Alarm> alarmMap = new HashMap<>();

    static {
        alarmMap.put(41001, AlarmActivation1.ALARM_0);
        alarmMap.put(41002, AlarmActivation2.ALARM_0);
    }

    public static Optional<String> getAlarmCode(Integer register, Integer alarmCode) {
        if (!alarmMap.containsKey(register)) return Optional.empty();
        return Optional.of(alarmMap.get(register).byAlarm(alarmCode));
    }
}
