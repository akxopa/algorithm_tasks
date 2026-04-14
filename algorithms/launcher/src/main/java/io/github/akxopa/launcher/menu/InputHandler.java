package io.github.akxopa.launcher.menu;

import java.util.Scanner;

/**
 * Reads user input from the console.
 * Closing this handler also closes {@code System.in}, so it should be done
 * only when the application is shutting down.
 */
public class InputHandler implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Prints a prompt and returns the trimmed user input.
     *
     * @param prompt message shown before reading input
     * @return trimmed user input
     */
    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Closes the underlying scanner.
     */
    @Override
    public void close() {
        scanner.close();
    }
}
