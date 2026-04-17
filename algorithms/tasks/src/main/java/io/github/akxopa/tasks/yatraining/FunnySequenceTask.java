package io.github.akxopa.tasks.yatraining;

import io.github.akxopa.common.Task;
import io.github.akxopa.common.model.TaskInfo;

/**
 * Finds the longest laughing substring.
 * Task from Yandex Algorithm training 2026, first section, second competition.
 */
public class FunnySequenceTask implements Task {

    private static final TaskInfo INFO = new TaskInfo(
            "yandex-1-2-1", // yandex-{section}-{competition}-{task number}
            "Yandex Algorithm training 2026",
            "Ахаха",
            "Cмех — это последовательность чередующихся букв \"a\" и \"h\".\n" + //
                    "Являются смехом: \"ahahaha\", \"hah\", \"h\" и \"a\".\n" + //
                    "Не являются смехом: \"abacaba\" и \"hh\".\n" + //
                    "\n" + //
                    "Необходимо выделить из строки самую длинную подстроку, которая является смехом, и вывести ее длину.\n"
                    + //
                    "\n" + //
                    "В первой строке находится одно натуральное число n от 1 до 10^5 — длина строки\n" + //
                    "Во второй строке находится строка из строчных латинских букв длины n.\n" + //
                    "\n" + //
                    "Ввод:\n" + //
                    "5\n" + //
                    "ahaha\n" + //
                    "\n" + //
                    "Вывод:\n" + //
                    "5",
            "5\nahaha",
            "5",
            "O(n)");

    @Override
    public TaskInfo getInfo() {
        return INFO;
    }

    @Override
    public void solve() {
        String input = INFO.inputExample();
        int output = maxLaugh(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }

    /**
     * Finds the longest sequence from letters {@code a} and {@code h}.
     * The characters should alternate.
     * 
     * @param s input string
     * @return length of the longest alternating substring made of 'a' and 'h'
     */
    public int maxLaugh(String s) {
        int maxCount = 0;
        int current = 0;

        if (s.length() == 1) {
            if (s.equals("a") || s.equals("h")) {
                maxCount = 1;

            }
            return maxCount;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // если не a и не h — сбрасываем
            if (c != 'a' && c != 'h') {
                current = 0;
                continue;
            }

            if (current == 0) {
                current = 1;
            } else {
                char prev = s.charAt(i - 1);

                if (c != prev) {
                    current++;
                } else {
                    current = 1;
                }
            }

            maxCount = Math.max(maxCount, current);
        }

        return maxCount;
    }

}
