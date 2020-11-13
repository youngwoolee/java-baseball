package util;

import domain.BaseBallNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {
    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        NumberGenerator generator = new RandomNumberGenerator();
        randomNumbers = generator.getNumbers();
    }

    @DisplayName("랜덤 숫자 1~9 에서 부터 3개 생성")
    @Test
    void getNumbers() {
        assertThat(randomNumbers.size()).isEqualTo(BaseBallNumbers.PICK_NUM_SIZE);
        assertThat(randomNumbers).containsAnyOf(1,2,3,4,5,6,7,8,9);
        System.out.println(Arrays.toString(randomNumbers.toArray()));
    }
}