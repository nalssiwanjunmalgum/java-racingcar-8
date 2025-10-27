package racingcar.util;

import static racingcar.domain.ErrorMessage.CHECK_DELIMITER_WHITESPACE;
import static racingcar.domain.ErrorMessage.DUPLICATED_MEMBER;
import static racingcar.domain.ErrorMessage.EMPTY_STRING;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNamesValidator {
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile("^[^,]{1,5}(,[^,]{1,5})*");
    public static final String COMMA_DELIMITER = ",";

    public static void validateDelimiter(String input) {
        validateNullOrBlank(input);
        validatePattern(input);
        validateDuplication(input);
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

    private static void validateDuplication(String input) {
        String[] names = input.split(COMMA_DELIMITER);
        long distinctCount = Arrays.stream(names)
                .map(String::trim)
                .distinct()
                .count();

        if (distinctCount != names.length) {
            throw new IllegalArgumentException(DUPLICATED_MEMBER.getMessage());
        }
    }
}
