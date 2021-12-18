package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


@Getter
@AllArgsConstructor
public enum Register {


    SERIAL_NUMBER(40001, 39, "", "Serial Number"),
    MODEL(40041, 39, "", "Model"),
    PACKAGE_NAME(40081, 39, "", "Package Name"),
    SOFTWARE_VERSION(40121, 39, "", "Software Version"),
    NOMINAL_AC_VOLTAGE(40161, 0, "V", "Nominal AC Voltage"),
    NOMINAL_BATTERY_VOLTAGE_DC(40162, 0, "V", "Nominal Battery Voltage (DC)"),
    ENGINE_MAKE(40163, 8, "", "Engine Make"),
    ENGINE_MODEL(40172, 8, "", "Engine Model"),
    ENGINE_SERIAL_NUMBER(40181, 8, "", "Engine Serial Number"),

    ALARM_ACTIVATION_1(41001, 0, "", "Alarms Activation 1"),
    ALARM_ACTIVATION_2(41002, 0, "", "Alarms Activation 2"),
    ALARM_ACTIVATION_3(41003, 0, "", "Alarms Activation 3"),
    ALARM_ACTIVATION_4(41004, 0, "", "Alarms Activation 4"),


    INPUT_STATUS_1(41005, 0, "", "Input Status 1"),
    OUTPUT_STATUS_1(41006, 0, "", "Output Status 1"),

    GPS_LATITUDE(41200, 0, "", "GPS Latitude"),
    GPS_LONGITUDE(41201, 0, "", "GPS Longitude"),
    GPS_DAY(41202, 0, "", "GPS Day"),
    GPS_TIME(41203, 0, "", "GPS Time"),
    SUPPLY_VOLTAGE(41204, 0, "V", "AC SupplyVoltage"),
    ENGINE_SPEED(41205, 0, "rpm", "Engine Speed"),
    ENGINE_WATER_TEMPERATURE(41206, 0, "deg C", "Engine Water Temperature"),
    OIL_PRESSURE(41207, 0, "bar", "Oil Pressure"),
    FUEL_LEVEL_SENSOR(41208, 0, "l", "Fuel Level Sensor"),
    OIL_TEMPERATURE(41209, 0, "deg C", "Oil Temperature"),
    SYSTEM_PRESSURE(41210, 0, "bar", "System Pressure"),
    SUCTION_PRESSURE(41211, 0, "bar", "Suction Pressure"),
    RAW_WATER_PRESSURE(41212, 0, "bar", "Raw Water Pressure"),
    PUMP_PRESSURE(41213, 0, "bar", "Pump Pressure"),
    RAW_WATER_TEMPERATURE(41500, 0, "deg C", "Raw Water Temp"),
    RAW_WATER_FLOW_SENSOR(41501, 0, "l/min", "Raw Water Flow Sensor"),
    DUTY_WATER_FLOW(41502, 0, "l/min", "Duty Water Flow"),
    BEARING_DRIVE_END_TEMP(41503, 0, "deg C", "Bearing Drive End Temp"),
    BEARING_NON_DRIVE_END_TEMP(41504, 0, "deg C", "Bearing Non Drive End Temp"),
    EXHAUST_TEMP(41505, 0, "deg C", "Exhaust Temp"),
    VIBRATION_SENSOR(41506, 0, "mm/s", "Vibration Sensor"),
    NOT_USED(41507, 0, "", ""),
    WATER_TANK_LEVEL(41600, 0, "kl", "Water Tank Level"),
    DAYS_SINCE_LAST_SERVICE(41700, 0, "", "Days Since Last Service"),
    RUN_HOURS_SINCE_LAST_SERVICE(41701, 0, "", "Run Hours Since Last Service"),

    MODBUS(40201, 99, "", "Modbus Manual/Auto Start"),

    BATTERY_1_VOLTAGE(42001, 0, "V", "Battery 1 Voltage"),
    BATTERY_2_VOLTAGE(42002, 0, "V", "Battery 2 Voltage"),
    NOT_USED_1(42003, 0, "", ""),
    BATTERY_1_CURRENT(42004, 0, "A", "Battery 1 Current"),
    BATTERY_2_CURRENT(42005, 0, "A", "Battery 2 Current"),
    NOT_USED_2(42006, 0, "", ""),
    NFPA_SYSTEM_PRESSURE(42007, 0, "kPa", "System Pressure"),
    NFPA_SUCTION_PRESSURE(42008, 0, "kPa", "System Pressure"),
    NOT_USED_3(42009, 0, "", ""),
    NOT_USED_4(42010, 0, "", ""),
    NOT_USED_5(42011, 0, "", ""),
    NFPA_ALARM_1(42012, 0, "", "NFPA Alarms 1"),
    NFPA_ALARM_2(42013, 0, "", "NFPA Alarms 2"),
    NFPA_ALARM_3(42014, 0, "", "NFPA Alarms 3"),
    NFPA_ALARM_4(42015, 0, "", "NFPA Alarms 4"),
    START_COUNT(42016, 0, "", "Start Count"),
    RUN_TIME(42017, 0, "hrs", "Run Time"),
    HOURS_SINCE_LAST_RUN(42018, 0, "hrs", "Hours Since Last Run"),
    NOT_USED_6(42019, 0, "", ""),
    CUT_IN(42029, 0, "", "Cut-In"),
    CUT_OUT(43030, 0, "kPa", "Cut-Out");


    private Integer address;
    private Integer registerSize;
    private String unit;
    private String friendlyName;

    public static Register byAddress(Integer address) {
        return Arrays.stream(Register.values()).filter(e -> e.address.equals(address)).findFirst().orElse(null);
    }

}
