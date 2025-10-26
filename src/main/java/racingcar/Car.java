package racingcar;

public class Car {
    private Position position;
    private final CarName carName;

    public Car(Position position, CarName carName) {
        this.position = position;
        this.carName = carName;
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
}
