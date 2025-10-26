package racingcar.domain.vo;

public class Round {
    private final long roundValue;
    private static final long ROUND_STANDARD = 0L;

    public Round(long roundValueInput) {
        validateRoundValue(roundValueInput);
        this.roundValue = roundValueInput;
    }

    private void validateRoundValue(Long roundValueInput) {
        if (roundValueInput < ROUND_STANDARD) {
            throw new IllegalArgumentException("라운드는 0이상만 가능합니다");
        }
    }
}
