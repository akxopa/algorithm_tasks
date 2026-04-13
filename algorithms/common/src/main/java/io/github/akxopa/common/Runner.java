package io.github.akxopa.common;


public class Runner {
    public static void run(Task task) {
        long start = System.nanoTime();
        task.solve();
        long end = System.nanoTime();

        System.out.println("Execution time: " + (end - start) / 1_000_000 + " ms");
    }
}
