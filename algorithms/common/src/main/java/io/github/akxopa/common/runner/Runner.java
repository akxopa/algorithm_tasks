package io.github.akxopa.common.runner;

import io.github.akxopa.common.Task;

/**
 * Executes a task and prints its execution time.
 */
public class Runner {
    /**
     * Runs the provided task.
     *
     * @param task task to execute
     */
    public void run(Task task) {
        long start = System.nanoTime();
        task.solve();
        long end = System.nanoTime();

        System.out.println();
        System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    }
}
