package racingcar.util;

import static racingcar.domain.ErrorMessage.CHECK_DELIMITER_WHITESPACE;
import static racingcar.domain.ErrorMessage.EMPTY_STRING;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNamesValidator {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[^,]{1,5}(,[^,]{1,5})*");

    public static void validateDelimiter(String input) {
        validateNullOrBlank(input);
        validatePattern(input);
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_STRING.getMessage());
        }
    }

    private static void validatePattern(String input) {
        Matcher matcher = CAR_NAME_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(CHECK_DELIMITER_WHITESPACE.getMessage());
        }
    }
}
