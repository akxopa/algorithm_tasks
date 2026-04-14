package io.github.akxopa.tasks.registry;

import io.github.akxopa.common.Task;
import io.github.akxopa.common.registry.TaskRegistry;
import io.github.akxopa.tasks.yatraining.YaTrainingDecodeStringTask;

import java.util.List;
import java.util.Optional;

/**
 * Default in-memory task registry used by the console application.
 */
public class DefaultTaskRegistry implements TaskRegistry {
    private final List<Task> tasks = List.of(
            new YaTrainingDecodeStringTask());

    /**
     * Returns all registered tasks.
     *
     * @return immutable task list
     */
    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Returns a task by its menu number.
     *
     * @param number task number shown to the user
     * @return matching task or an empty result if the number is invalid
     */
    @Override
    public Optional<Task> getByNumber(int number) {
        if (number < 1 || number > tasks.size()) {
            return Optional.empty();
        }

        return Optional.of(tasks.get(number - 1));
    }
}
