package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RandomCarSignals {
    private final List<CarSignal> carSignalList;

    public RandomCarSignals(List<Integer> numbers) {
        this.carSignalList = new ArrayList<>();
        initCarSignals(numbers);
    }

    public CarSignal getSignalAtIndex(int idx) {
        return carSignalList.get(idx);
    }

    private void initCarSignals(List<Integer> numbers) {
        for (int num : numbers) {
            carSignalList.add(new CarSignal(num));
        }
    }

    public List<CarSignal> getCarSignals() {
        return List.copyOf(carSignalList);
    }
}
