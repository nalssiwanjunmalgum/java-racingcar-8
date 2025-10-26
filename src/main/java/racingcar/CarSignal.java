package racingcar;

public class CarSignal {
    private final int carSignalValue;
    private static final int STANDARD = 4;

    public CarSignal(int carSignalValue) {
        this.carSignalValue = carSignalValue;
    }

    public boolean isPermitted() {
        return carSignalValue >= STANDARD;
    }

    public int getCarSignalValue() {
        return carSignalValue;
    }
}
