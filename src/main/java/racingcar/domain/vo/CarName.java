package racingcar.domain.vo;

import java.util.Objects;

public class CarName {
    private static final int LIMIT_LENGTH = 5;
    private final String nameValue;

    public CarName(String name) {
        validateName(name);
        this.nameValue = name;
    }

    public String getNameValue() {
        return nameValue;
    }

    private void validateName(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String name) {
        if (name.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                      // 동일 객체일 경우 true
        if (o == null || getClass() != o.getClass()) return false; // 타입 다르면 false
        CarName carName = (CarName) o;
        return Objects.equals(nameValue, carName.nameValue);  // 값 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameValue);
    }

    @Override
    public String toString() {
        return nameValue;
    }
}
