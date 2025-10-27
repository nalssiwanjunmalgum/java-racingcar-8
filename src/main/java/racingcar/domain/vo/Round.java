package racingcar.domain.vo;

import static racingcar.domain.ErrorMessage.PERMIT_POSITIVE_ROUND;

public class Round {
    private static final long ROUND_STANDARD = 0L;
    private static final long DECREASE_AMOUNT = 1L;
    private final long roundValue;

    public Round(long roundValueInput) {
        validateRoundValue(roundValueInput);
        this.roundValue = roundValueInput;
    }

    public Round decrease() {
        return new Round(roundValue - DECREASE_AMOUNT);
    }

    public boolean isLeft() {
        return roundValue > ROUND_STANDARD;
    }
    private void validateRoundValue(long roundValueInput) {
        if (roundValueInput < ROUND_STANDARD) {
            throw new IllegalArgumentException(PERMIT_POSITIVE_ROUND.getMessage());
        }
    }
}
