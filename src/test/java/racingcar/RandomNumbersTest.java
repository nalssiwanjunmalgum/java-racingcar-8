package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.MockNumberProvider;
import racingcar.util.NumberProvider;
import racingcar.util.RandomNumberProvider;

public class RandomNumbersTest {

    @Nested
    @DisplayName("Mocking")
    class MockNumberProviderTest {
        private NumberProvider mockedNumberProvider;

        @BeforeEach
        void setUp() {
            mockedNumberProvider = new MockNumberProvider(
                    List.of(1, 3, 4)
            );
        }

        @Test
        @DisplayName("Mocking으로 제공")
        void validate_internal_element() {
            List<Integer> mockedNumbers = mockedNumberProvider.provideNumber(3);
            Assertions.assertThat(mockedNumbers)
                    .containsExactly(1, 3, 4);
        }
    }

    @Nested
    @DisplayName("Random")
    class RandomNumberProviderTest {
        private NumberProvider randomNumberProvider;

        @BeforeEach
        void setUp() {
            randomNumberProvider = new RandomNumberProvider();
        }

        @Test
        @DisplayName("Random으로 생성된 경우")
        void validate_internal_element() {
            List<Integer> mockedNumbers = randomNumberProvider.provideNumber(3);
            Assertions.assertThat(mockedNumbers)
                    .allMatch(num -> num <= 9 && num >= 0);
        }
    }

}
