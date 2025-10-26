package racingcar;

public class Car {
    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    public void move() {
        this.position = position.increment();
    }

    public Position getPosition() {
        return position;
    }
}
