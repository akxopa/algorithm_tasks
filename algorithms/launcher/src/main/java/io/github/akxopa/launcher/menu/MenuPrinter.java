package io.github.akxopa.launcher.menu;

import io.github.akxopa.common.Task;
import io.github.akxopa.common.model.TaskInfo;

import java.util.List;

/**
 * Prints menus, task cards, and service messages for the console UI.
 */
public class MenuPrinter {
    /**
     * Prints the main menu with all available tasks.
     *
     * @param tasks ordered task list
     */
    public void printMainMenu(List<Task> tasks) {
        System.out.println();
        System.out.println("Список задач:");
        for (int i = 0; i < tasks.size(); i++) {
            TaskInfo info = tasks.get(i).getInfo();
            System.out.printf("%d: [%s] %s%n", i + 1, info.source(), info.title());
        }
        System.out.println("0: Exit");
        System.out.println();
    }

    /**
     * Prints full task information and available commands.
     *
     * @param task selected task
     */
    public void printTaskCard(Task task) {
        TaskInfo info = task.getInfo();

        System.out.println();
        System.out.println(info.title());
        System.out.println("Источник: " + info.source());
        System.out.println("ID: " + info.id());
        System.out.println("Оценка сложности: " + info.complexity());
        System.out.println();
        System.out.println(info.description());
        System.out.println();
        System.out.println("Пример входных данных:");
        System.out.println(info.inputExample());
        System.out.println();
        System.out.println("Пример выходных данных:");
        System.out.println(info.outputExample());
        System.out.println();
        System.out.println("s: запустить решение задачи");
        System.out.println("m: выйти в меню");
        System.out.println("0: завершить приложение");
        System.out.println();
    }

    /**
     * Prints a header before task execution.
     *
     * @param task task to run
     */
    public void printTaskRunHeader(Task task) {
        System.out.println();
        System.out.println("Запуск задачи: " + task.getInfo().title());
        System.out.println();
    }

    /**
     * Prints a message for unsupported user commands.
     */
    public void printUnknownCommand() {
        System.out.println("Неизвестная команда. Попробуйте еще раз.");
    }

    /**
     * Prints a message for an invalid task number.
     */
    public void printInvalidTaskNumber() {
        System.out.println("Задачи с таким номером нет.");
    }

    /**
     * Prints the final application message.
     */
    public void printExitMessage() {
        System.out.println("Приложение завершено.");
    }
}
