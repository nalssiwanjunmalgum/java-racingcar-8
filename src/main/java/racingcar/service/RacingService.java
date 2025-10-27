package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.vo.RandomCarSignals;
import racingcar.domain.vo.Round;
import racingcar.util.NumberProvider;

public class RacingService {
    private final NumberProvider numberProvider;
    private Round round;
    private RacingCars racingCars;

    public RacingService(NumberProvider numberProvider) {
        this.numberProvider = numberProvider;
    }

    public void registerInfo(String roundInput, String carNamesInput) {
        this.round = registerRound(roundInput);
        this.racingCars = registerCarNames(carNamesInput);
    }

    public boolean hasMoreRound() {
        return round.isLeft();
    }

    public RacingCars executePerRound() {
        round = round.decrease();
        List<Integer> providedNumbers = numberProvider.provideNumber(racingCars.getSize());
        racingCars.receiveSignals(new RandomCarSignals(providedNumbers));
        return racingCars;
    }

    public List<Car> getWinner() {
        return racingCars.findWinner();
    }

    private Round registerRound(String input) {
        return new Round(Long.parseLong(input));
    }

    private RacingCars registerCarNames(String input) {
        return new RacingCars(input);
    }
}
