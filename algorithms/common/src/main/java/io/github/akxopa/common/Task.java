package io.github.akxopa.common;

import io.github.akxopa.common.model.TaskInfo;

/**
 * Describes an algorithm task that can be shown in the menu and executed.
 */
public interface Task {
    /**
     * Returns static metadata used in the application menu and task card.
     *
     * @return task metadata
     */
    TaskInfo getInfo();

    /**
     * Runs the task solution demo in the console.
     */
    void solve();
}
