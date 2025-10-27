package racingcar.domain.vo;

public class CarSignal {
    private static final int STANDARD = 4;
    private final int carSignalValue;

    public CarSignal(int carSignalValue) {
        this.carSignalValue = carSignalValue;
    }

    public boolean isPermitted() {
        return carSignalValue >= STANDARD;
    }
}
