package racingcar;

import java.util.Objects;

public class Position {
    private final long positionValue;

    public Position(long positionValue) {
        validatePositionValue(positionValue);
        this.positionValue = positionValue;
    }

    public Position() {
        this.positionValue = 0L;
    }

    public Position increment() {
        return new Position(positionValue + 1);
    }

    private void validatePositionValue(long positionValue) {
        if (positionValue < 0) {
            throw new IllegalArgumentException();
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
