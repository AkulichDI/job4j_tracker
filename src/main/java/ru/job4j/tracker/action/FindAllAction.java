package ru.job4j.tracker.action;

import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;

import java.util.List;

import static ru.job4j.tracker.StartUI.showInfoItem;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction (Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Вывод всех заявок ";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        output.println("==== Вывод всех заявок ====");
        List<Item> items = memTracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                showInfoItem(output, item);
            }
        }else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
