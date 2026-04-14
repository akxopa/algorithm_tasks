package io.github.akxopa.launcher;

import io.github.akxopa.common.registry.TaskRegistry;
import io.github.akxopa.tasks.registry.DefaultTaskRegistry;

/**
 * Application entry point.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskRegistry taskRegistry = new DefaultTaskRegistry();
        Application application = new Application(taskRegistry);
        application.start();
    }
}
