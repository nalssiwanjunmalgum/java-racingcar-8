package racingcar;

public class CarName {
    private final String nameValue;
    private static final int LIMIT_LENGTH = 5;

    public CarName(String name) {
        validateName(name);
        this.nameValue = name;
    }

    private void validateName(String name) {
        if (name.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
