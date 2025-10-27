package racingcar.domain;

public enum ErrorMessage {
    PERMIT_POSITIVE_ROUND("라운드는 0이상만 가능합니다"),
    UNMATCHED_CARS_WITH_SIGNALS("자동차 개수와 신호의 수가 서로 다릅니다."),
    EMPTY_STRING("비어있는 문자열을 입력했습니다."),
    CHECK_DELIMITER_WHITESPACE("구분자와 공백을 확인해주세요."),
    CHECK_NUMBERS_SIZE("주입하는 수의 크기에 문제가 있습니다."),
    ENTER_NUMBER("수를 입력해주세요."),
    OVER_LETTER_LIMIT("글자 제한을 넘었습니다."),
    PERMIT_POSSIBLE_POSITION("위치는 양수만 가능합니다.")
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
