package io.github.akxopa.tasks.yatraining;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import io.github.akxopa.tasks.yatraining.YaTrainingDecodeStringTask;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

class YaTrainingDecodeStringTaskTest {
    private final YaTrainingDecodeStringTask task = new YaTrainingDecodeStringTask();

    /**
     * Проверяет базовые случаи декодирования:
     * - одиночные символы a-i (однозначные числа)
     * - одиночные символы j-z (двузначные числа с #)
     * - комбинации символов
     */
    @ParameterizedTest(name = "\"{0}\" → \"{1}\"")
    @CsvSource({
            "1, a",
            "9, i",
            "10#, j",
            "26#, z",
            "12#, l",
            "15#, o",
            "23#, w",
            "123#, aw"
    })
    @DisplayName("Одиночные символы")
    void testSingleCharacters(String encoded, String expected) {
        assertEquals(expected, task.decode(encoded));
    }

    /**
     * Проверяет корректность декодирования строки
     */
    @Test
    @DisplayName("Пример: helloworld")
    void testExampleFromTask() {
        String encoded = "8512#12#15#23#15#18#12#4";
        String expected = "helloworld";
        assertEquals(expected, task.decode(encoded));
    }

    /**
     * Проверяет граничные случаи:
     * - минимальная строка из одного символа 'a'
     * - максимальная строка из одного символа 'z'
     * - максимальная длина закодированной строки (100 символов)
     * создается строка из 33 символов 'z' (33 * 3 = 99 символов)
     */
    @Test
    @DisplayName("Граничные случаи")
    void testBoundaryCases() {
        // Минимальный символ
        assertEquals("a", task.decode("1"));

        // Максимальный символ
        assertEquals("z", task.decode("26#"));

        // Строка из 33 символов 'z' (33 * 3 = 99 символов, что ≤ 100)
        String encodedZ33 = "26#".repeat(33);
        String expectedZ33 = "z".repeat(33);
        assertEquals(expectedZ33, task.decode(encodedZ33));
    }

    /**
     * Проверяет строку, содержащую все буквы алфавита от a до z
     */
    @Test
    @DisplayName("Весь алфавит a-z")
    void testFullAlphabet() {
        StringBuilder encoded = new StringBuilder();
        StringBuilder expected = new StringBuilder();

        for (int i = 1; i <= 26; i++) {
            expected.append((char) ('a' + i - 1));
            if (i <= 9) {
                encoded.append(i);
            } else {
                encoded.append(i).append("#");
            }
        }

        assertEquals(expected.toString(), task.decode(encoded.toString()));
    }
}
