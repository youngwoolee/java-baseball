package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}