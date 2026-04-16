package io.github.akxopa.tasks.yatraining;

import io.github.akxopa.common.Task;
import io.github.akxopa.common.model.TaskInfo;

/**
 * Demonstration task that decodes a string in the
 * Yandex Algorithm training 2026 format.
 */
public class YaTrainingDecodeStringTask implements Task {
    private static final TaskInfo INFO = new TaskInfo(
            "yandex-001",
            "Yandex Algorithm training 2026",
            "Decode the string",
            "Раскодируй строку:\n" + //
                    "символам a - i соответсвуют числа 1 по 9\n" + //
                    "символам j - z соответсвуют 10# по 26#\n\n" + //
                    "Формат ввода:\n" + //
                    "На первой строке дана последовательность размером от 1 до 100 состоящая из цифр и символа «#».\n" + //
                    "Гарантируется, что последовательность получена кодированием какой-то исходной\n" + //
                    "строки, состоящей из строчных латинских букв.\n\n" + //
                    "Формат вывода:\n" + //
                    "Вывести раскодированную строку.\n\n" + //
                    "Пример:\n" + //
                    "Ввод\n" + //
                    "8512#12#15#23#15#18#12#4\n\n" + //
                    "Вывод\n" + //
                    "helloworld",
            "8512#12#15#23#15#18#12#4",
            "helloworld");

    @Override
    public TaskInfo getInfo() {
        return INFO;
    }

    @Override
    public void solve() {
        String input = INFO.inputExample();
        String decoded = decode(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + decoded);
    }

    /**
     * Decodes a string where letters {@code a-i} are written as {@code 1-9}
     * and letters {@code j-z} are written as {@code 10#-26#}.
     *
     * @param line encoded string
     * @return decoded string
     */
    public String decode(String line) {
        StringBuilder result = new StringBuilder();

        int l = line.length() - 1;
        int num = 0;

        while (l >= 0) {
            if (line.charAt(l) == '#' && l >= 2) {
                String str = String.valueOf(line.charAt(l - 2)) + String.valueOf(line.charAt(l - 1));
                num = Integer.parseInt(str);
                result.append(toChar(num));
                l -= 3;
            } else {
                num = Integer.parseInt(String.valueOf(line.charAt(l)));
                result.append(toChar(num));
                l--;
            }
        }

        return result.reverse().toString();
    }

    /**
     * Converts a numeric token to the corresponding lowercase Latin letter.
     *
     * @param digitString one-digit or two-digit numeric token
     * @return decoded character
     */
    private char toChar(int num) {
        return (char) ('a' + num - 1);
    }
}
