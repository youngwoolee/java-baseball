package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    private static final String REGEX = ",";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";

    @DisplayName("요구사항 1: 스트링 분리 테스트")
    @Test
    public void stringSplit() {
        String argument1 = "1,2";
        String argument2 = "1";
        assertThat(argument1.split(REGEX)).contains("1","2");
        assertThat(argument2.split(REGEX)).containsExactly("1");
    }

    @DisplayName("요구사항 2: 서브스트링 테스트")
    @Test
    public void stringSubString() {
        String argument1 = "(1,2)";
        assertThat(argument1.substring(argument1.indexOf(OPEN_BRACKET) + 1, argument1.indexOf(CLOSE_BRACKET))).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3: charAt 테스트")
    @Test
    public void stringCharAt() {
        String argument1 = "abc";
        assertThat(argument1.charAt(0)).isEqualTo('a');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> argument1.charAt(5))
                .withMessageMatching("String index out of range: 5");
    }





}
