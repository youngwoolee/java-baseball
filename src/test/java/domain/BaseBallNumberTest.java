package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BaseBallNumberTest {

    @DisplayName("생성 성공 : 1~9 사이의 숫자 생성")
    @Test
    public void createBaseBallNumber() {
        assertThat(BaseBallNumber.of(1, 5).getIndex()).isEqualTo(1);
        assertThat(BaseBallNumber.of(1, 8).getNumber()).isEqualTo(8);
    }

    @DisplayName("생성 실패 : 1~9 가 아닌 숫자로 생성")
    @Test
    public void createBaseBallWrongNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseBallNumber.of(1, 10));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> BaseBallNumber.of(1, 0));
    }

    @DisplayName("값 비교 : 인덱스와 값에 따라 STRIKE, BALL, OUT 으로 리턴")
    @ParameterizedTest
    @MethodSource
    void compareBaseBallNumberWithAnswer(BaseBallNumber baseBallNumber, BaseBallNumberResult baseBallNumberResult) {
        BaseBallNumbers answers = BaseBallNumbers.of(Arrays.asList(1, 2, 3));
        assertThat(baseBallNumber.compareBaseBallNumber(answers.getBaseBallNumbers())).isEqualTo(baseBallNumberResult);
    }

    static Stream<Arguments> compareBaseBallNumberWithAnswer() {
        return Stream.of(
                Arguments.of(BaseBallNumber.of(0, 1), BaseBallNumberResult.STRIKE),
                Arguments.of(BaseBallNumber.of(1, 1), BaseBallNumberResult.BALL),
                Arguments.of(BaseBallNumber.of(2, 4), BaseBallNumberResult.OUT)
        );
    }

}