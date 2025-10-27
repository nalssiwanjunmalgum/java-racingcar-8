package racingcar.domain.vo;

import static racingcar.domain.ErrorMessage.PERMIT_POSSIBLE_POSITION;

import java.util.Objects;

public class Position {
    private static final int INCREASE_AMOUNT = 1;
    private final long positionValue;

    public Position(long positionValue) {
        validatePositionValue(positionValue);
        this.positionValue = positionValue;
    }

    public Position() {
        this.positionValue = 0L;
    }

    public Position increment() {
        return new Position(positionValue + INCREASE_AMOUNT);
    }

    public long getPositionValue() {
        return positionValue;
    }

    private void validatePositionValue(long positionValue) {
        if (positionValue < 0) {
            throw new IllegalArgumentException(PERMIT_POSSIBLE_POSITION.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                      // 동일 객체일 경우 true
        if (o == null || getClass() != o.getClass()) return false; // 타입 다르면 false
        Position position = (Position) o;
        return positionValue == position.positionValue;  // 값 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionValue);
    }
}
