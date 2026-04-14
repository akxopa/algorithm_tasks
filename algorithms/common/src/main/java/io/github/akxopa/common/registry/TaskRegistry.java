package io.github.akxopa.common.registry;

import io.github.akxopa.common.Task;

import java.util.List;
import java.util.Optional;

/**
 * Provides access to tasks available in the application menu.
 */
public interface TaskRegistry {
    /**
     * Returns all registered tasks in the order they should be shown in the menu.
     *
     * @return ordered task list
     */
    List<Task> getAllTasks();

    /**
     * Finds a task by its menu number.
     *
     * @param number task number shown to the user, starting from 1
     * @return matching task or an empty result if the number is invalid
     */
    Optional<Task> getByNumber(int number);
}
