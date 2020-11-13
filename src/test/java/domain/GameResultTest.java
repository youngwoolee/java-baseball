package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {


    @DisplayName("정답 여부 : 전부 STRIKE 일때만 true")
    @ParameterizedTest
    @MethodSource
    void isSuccess(GameResult gameResult, boolean expected) {
        assertThat(gameResult.isSuccess()).isEqualTo(expected);
    }

    static Stream<Arguments> isSuccess() {
        return Stream.of(
                Arguments.of(GameResult.of(Arrays.asList(BaseBallNumberResult.STRIKE, BaseBallNumberResult.STRIKE, BaseBallNumberResult.STRIKE)), true),
                Arguments.of(GameResult.of(Arrays.asList(BaseBallNumberResult.STRIKE, BaseBallNumberResult.BALL, BaseBallNumberResult.STRIKE)), false),
                Arguments.of(GameResult.of(Arrays.asList(BaseBallNumberResult.BALL, BaseBallNumberResult.BALL, BaseBallNumberResult.BALL)), false)
        );
    }

    @DisplayName("낫싱 여부 : 전부 OUT 일때만 true")
    @ParameterizedTest
    @MethodSource
    void isNothing(GameResult gameResult, boolean expected) {
        assertThat(gameResult.isNothing()).isEqualTo(expected);
    }

    static Stream<Arguments> isNothing() {
        return Stream.of(
                Arguments.of(GameResult.of(Arrays.asList(BaseBallNumberResult.STRIKE, BaseBallNumberResult.STRIKE, BaseBallNumberResult.STRIKE)), false),
                Arguments.of(GameResult.of(Arrays.asList(BaseBallNumberResult.STRIKE, BaseBallNumberResult.BALL, BaseBallNumberResult.STRIKE)), false),
                Arguments.of(GameResult.of(Arrays.asList(BaseBallNumberResult.OUT, BaseBallNumberResult.OUT, BaseBallNumberResult.OUT)), true)
        );
    }
}