package za.amakosi.panelprocessor.domain.aggregate.panel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PanelResponseMessage {

    private Integer controllerAddress;
    private ModbusFunctionCode modbusFunction;
    private Integer numberOfBytes;
    private List<String> registerHexValues;
    private String error;

    private PanelResponseMessage(int contAddress, int modFunction, int numBytes, List<String> registerHexes) {
        controllerAddress = contAddress;
        modbusFunction = ModbusFunctionCode.byCode(modFunction);
        numberOfBytes = numBytes;
        registerHexValues = registerHexes;
    }

    public static PanelResponseMessage valueOf(String incoming) {
        final int MINIMUM_MESSAGE_LENGTH = 6;
        final int CONT_ADDRESS_START_INDEX = 0;
        final int CONT_ADDRESS_END_INDEX = 2;
        final int MOD_FUNCTION_START_INDEX = 2;
        final int MOD_FUNCTION_END_INDEX = 4;
        final int NUM_BYTES_START_INDEX = 4;
        final int NUM_BYTES_END_INDEX = 6;
        final int RADIX = 16;
        String noWhiteSpaceMessage = removeWhiteSpace(incoming);

        int contAddress, modFunction, numBytes;
        if (noWhiteSpaceMessage.length() >= MINIMUM_MESSAGE_LENGTH) {
            contAddress = Integer.parseInt(noWhiteSpaceMessage.substring(CONT_ADDRESS_START_INDEX, CONT_ADDRESS_END_INDEX), RADIX);
            modFunction = Integer.parseInt(noWhiteSpaceMessage.substring(MOD_FUNCTION_START_INDEX, MOD_FUNCTION_END_INDEX), RADIX);
            numBytes = Integer.parseInt(noWhiteSpaceMessage.substring(NUM_BYTES_START_INDEX, NUM_BYTES_END_INDEX), RADIX);

            return new PanelResponseMessage(contAddress, modFunction, numBytes, registerValuesFrom(noWhiteSpaceMessage));
        }
        return PanelResponseMessage.builder().error("malformed incoming message").build();
    }

    private static String removeWhiteSpace(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, chars.length).forEachOrdered(i -> {
            char c = chars[i];
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            }
        });
        return sb.toString();
    }

    private static List<String> registerValuesFrom(String input) {
        var registerList = new ArrayList<String>();
        for (int i = 6 ; i < input.length() - 1 ; i++) {
            registerList.add(input.substring(i, i + 4));
            i += 3;
        }
        return registerList;
    }
}
