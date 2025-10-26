package racingcar;

import java.util.Objects;

public class Car {
    private Position position;
    private final CarName carName;

    public Car(Position position, CarName carName) {
        this.position = position;
        this.carName = carName;
    }

    public Car(CarName carName) {
        this.position = new Position(0L);
        this.carName = carName;
    }

    public void receiveCarSignal(CarSignal carSignal) {
        if (carSignal.isPermitted()) {
            move();
        }
    }

    public void move() {
        this.position = position.increment();
    }

    public Position getPosition() {
        return new Position(position.getPositionValue());
    }

    public CarName getCarName() {
        return new CarName(carName.getNameValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                      // 동일 객체일 경우 true
        if (o == null || getClass() != o.getClass()) return false; // 타입 다르면 false
        Car car = (Car) o;
        return Objects.equals(position, car.position)
                && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, carName);
    }
}
