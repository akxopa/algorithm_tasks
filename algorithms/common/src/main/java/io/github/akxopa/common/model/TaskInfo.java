package io.github.akxopa.common.model;

/**
 * Stores task metadata displayed in the console application.
 *
 * @param id unique task identifier inside the project
 * @param source task source, for example CodeRun or LeetCode
 * @param title task title shown in the menu
 * @param description short task description
 * @param inputExample example of input data
 * @param outputExample example of output data
 */
public record TaskInfo(
        String id,
        String source,
        String title,
        String description,
        String inputExample,
        String outputExample) {
}
