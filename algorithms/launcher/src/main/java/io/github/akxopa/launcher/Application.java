package io.github.akxopa.launcher;

import io.github.akxopa.common.Task;
import io.github.akxopa.common.registry.TaskRegistry;
import io.github.akxopa.common.runner.Runner;
import io.github.akxopa.launcher.menu.InputHandler;
import io.github.akxopa.launcher.menu.MenuPrinter;

import java.util.Optional;

/**
 * Coordinates the main application flow: splash screen, menu navigation,
 * task selection, and task execution.
 */
public class Application {
    private final TaskRegistry taskRegistry;
    private final MenuPrinter menuPrinter;
    private final InputHandler inputHandler;
    private final Runner runner;
    private final SplashScreen splashScreen;

    public Application(TaskRegistry taskRegistry) {
        this.taskRegistry = taskRegistry;
        this.menuPrinter = new MenuPrinter();
        this.inputHandler = new InputHandler();
        this.runner = new Runner();
        this.splashScreen = new SplashScreen();
    }

    /**
     * Starts the application event loop.
     *
     * @throws InterruptedException if the splash screen animation is interrupted
     */
    public void start() throws InterruptedException {
        try {
            splashScreen.startApp();

            boolean running = true;
            while (running) {
                menuPrinter.printMainMenu(taskRegistry.getAllTasks());
                String command = inputHandler.readLine("Выберите номер задачи или 0 для выхода: ");

                if ("0".equals(command)) {
                    running = false;
                    continue;
                }

                try {
                    int taskNumber = Integer.parseInt(command);
                    Optional<Task> task = taskRegistry.getByNumber(taskNumber);

                    if (task.isPresent()) {
                        openTaskCard(task.get());
                    } else {
                        menuPrinter.printInvalidTaskNumber();
                    }
                } catch (NumberFormatException ex) {
                    menuPrinter.printUnknownCommand();
                }
            }

            menuPrinter.printExitMessage();
        } finally {
            inputHandler.close();
        }
    }

    /**
     * Shows a selected task card and handles task-specific commands.
     *
     * @param task selected task
     */
    private void openTaskCard(Task task) {
        boolean inTaskMenu = true;

        while (inTaskMenu) {
            menuPrinter.printTaskCard(task);
            String command = inputHandler.readLine("Введите команду (s/m/0): ");

            switch (command) {
                case "s" -> {
                    menuPrinter.printTaskRunHeader(task);
                    runner.run(task);
                    inputHandler.readLine("Нажмите Enter, чтобы вернуться к задаче...");
                }
                case "m" -> inTaskMenu = false;
                case "0" -> {
                    menuPrinter.printExitMessage();
                    System.exit(0);
                }
                default -> menuPrinter.printUnknownCommand();
            }
        }
    }
}
