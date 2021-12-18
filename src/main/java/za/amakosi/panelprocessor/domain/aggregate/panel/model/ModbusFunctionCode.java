package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum ModbusFunctionCode {
    READ_MULTIPLE_REGISTERS(3,"03"),
    WRITE_SINGLE_REGISTER(6, "06"),
    COMMAND(10, "0A"),
    WRITE_MULTIPLE_REGISTERS(16, "10");

    private Integer code;
    private String hexCode;


    public static ModbusFunctionCode byCode(Integer code) {
        return Arrays.stream(ModbusFunctionCode.values()).filter(e -> e.code.equals(code)).findFirst().orElse(null);
    }

    public static String byCodeToHex(Integer code) {
        ModbusFunctionCode modbusFunctionCode = Arrays.stream(ModbusFunctionCode.values())
                .filter(e -> e.code.equals(code))
                .findFirst().orElse(null);
        return modbusFunctionCode.hexCode;
    }

}
