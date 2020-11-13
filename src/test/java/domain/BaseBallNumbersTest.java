package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class BaseBallNumbersTest {

    @DisplayName("생성 성공 : 개수 3개 일치")
    @ParameterizedTest
    @MethodSource
    void createBaseBallNumbers(List<Integer> numbers, int expected) {
        BaseBallNumbers baseBallNumbers = BaseBallNumbers.of(numbers);
        assertThat(baseBallNumbers.getBaseBallNumbers().size()).isEqualTo(expected);
    }

    static Stream<Arguments> createBaseBallNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3), 3),
                Arguments.of(Arrays.asList(4,5,6), 3)
        );
    }

    @DisplayName("생성 실패 : 개수가 많거나 적음")
    @ParameterizedTest
    @MethodSource
    void createBaseBallNumbersFailure(List<Integer> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseBallNumbers.of(numbers));
    }

    static Stream<Arguments> createBaseBallNumbersFailure() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4)),
                Arguments.of(Arrays.asList(1,2))
        );
    }

    @DisplayName("생성 실패 : 중복된 숫자로 생성")
    @Test
    void createBaseBallNumbersFailureDuplicate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseBallNumbers.of(Arrays.asList(3, 3, 3)));
    }

    @DisplayName("값 비교 : STRIKE, BALL, OUT 개수를 포함한 GameResult 으로 리턴")
    @ParameterizedTest
    @MethodSource
    void compareBaseBallNumbersWithAnswer(BaseBallNumbers baseBallNumbers, GameResult gameResult) {
        BaseBallNumbers answers = BaseBallNumbers.of(Arrays.asList(1, 2, 3));
        assertThat(answers.compareBaseBallNumbers(baseBallNumbers)).isEqualTo(gameResult);
    }

    static Stream<Arguments> compareBaseBallNumbersWithAnswer() {
        return Stream.of(
                Arguments.of(BaseBallNumbers.of(Arrays.asList(1, 2, 3)), GameResult.of(Arrays.asList(BaseBallNumberResult.STRIKE, BaseBallNumberResult.STRIKE, BaseBallNumberResult.STRIKE))),
                Arguments.of(BaseBallNumbers.of(Arrays.asList(3, 1, 2)), GameResult.of(Arrays.asList(BaseBallNumberResult.BALL, BaseBallNumberResult.BALL, BaseBallNumberResult.BALL))),
                Arguments.of(BaseBallNumbers.of(Arrays.asList(4, 5, 6)), GameResult.of(Arrays.asList(BaseBallNumberResult.OUT, BaseBallNumberResult.OUT, BaseBallNumberResult.OUT))),
                Arguments.of(BaseBallNumbers.of(Arrays.asList(3, 2, 1)), GameResult.of(Arrays.asList(BaseBallNumberResult.BALL, BaseBallNumberResult.STRIKE, BaseBallNumberResult.BALL)))
        );
    }


}