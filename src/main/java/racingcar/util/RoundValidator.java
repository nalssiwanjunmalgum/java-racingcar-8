package racingcar.util;

import static racingcar.domain.ErrorMessage.ENTER_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoundValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    public static void validateNumber(String input) {
        Matcher matcher = NUMBER_PATTERN.matcher(input.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ENTER_NUMBER.getMessage());
        }
    }
}
