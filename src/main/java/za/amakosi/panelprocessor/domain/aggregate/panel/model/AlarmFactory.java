package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AlarmFactory {

    static Map<Integer, Alarm> alarmMap = new HashMap<>();

    static {
        alarmMap.put(41001, AlarmActivation1.ALARM_0);
        alarmMap.put(41002, AlarmActivation2.ALARM_0);
        alarmMap.put(41003, AlarmActivation3.ALARM_0);
        alarmMap.put(41004, AlarmActivation4.ALARM_0);
        alarmMap.put(41005, InputStatus1.ALARM_0);
        alarmMap.put(41006, OutputStatus1.ALARM_0);
        alarmMap.put(42012, NFPAAlarm1.ALARM_0);
        alarmMap.put(42013, NFPAAlarm2.ALARM_0);
        alarmMap.put(42014, NFPAAlarm3.ALARM_0);
        alarmMap.put(42015, NFPAAlarm4.ALARM_0);
    }

    public static Optional<String> getAlarmCode(Integer register, Integer alarmCode) {
        return !alarmMap.containsKey(register) ? Optional.empty() : Optional.of(alarmMap.get(register).byAlarm(alarmCode));
    }
}
