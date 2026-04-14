package io.github.akxopa.launcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Prints a short animated greeting before the main menu appears.
 */
public class SplashScreen {
    /**
     * Shows the splash screen animation.
     *
     * @throws InterruptedException if the animation sleep is interrupted
     */
    public void startApp() throws InterruptedException {
        String title = "Algorithm Tasks";
        char[] result = new char[title.length()];
        Arrays.fill(result, ' ');
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < title.length(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        for (int index : indices) {
            result[index] = title.charAt(index);
            System.out.print("\r");
            for (char c : result) {
                System.out.print(c);
            }
            Thread.sleep(100);
        }
        System.out.println();
        System.out.println("================");
        System.out.println("Консольный сборник алгоритмических задач.");

    }
}
