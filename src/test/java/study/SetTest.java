package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1: set 사이즈 테스트")
    @Test
    public void setSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2: set contains 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setContains(final int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }

    @DisplayName("요구사항 3: set contains 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void setContainsMultiValue(final int argument, final Boolean expected) {
        assertEquals(expected, numbers.contains(argument));
    }


}