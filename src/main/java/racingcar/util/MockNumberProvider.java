package racingcar.util;

import static racingcar.domain.ErrorMessage.CHECK_NUMBERS_SIZE;

import java.util.List;

public class MockNumberProvider implements NumberProvider{
    private final List<Integer> mockList;

    public MockNumberProvider(List<Integer> mockList) {
        this.mockList = List.copyOf(mockList);
    }

    @Override
    public List<Integer> provideNumber(int size) {
        hasSameNumberSize(size);
        return List.copyOf(mockList);
    }

    private void hasSameNumberSize(int size) {
        if (mockList.size() != size) {
            throw new IllegalArgumentException(CHECK_NUMBERS_SIZE.getMessage());
        }
    }
}
