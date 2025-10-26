package racingcar.util;

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
            throw new IllegalArgumentException("비어있는 문자열을 입력했습니다.");
        }
    }

    private static void validatePattern(String input) {
        Matcher matcher = CAR_NAME_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("구분자와 공백을 확인해주세요.");
        }
    }
}
