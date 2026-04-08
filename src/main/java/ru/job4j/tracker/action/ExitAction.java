package ru.job4j.tracker.action;

import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ExitAction implements UserAction{
    private final Output output;

    public ExitAction (Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "Завершить программу";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        output.println("=== Завершение программы ===");
        return false;
    }
}
