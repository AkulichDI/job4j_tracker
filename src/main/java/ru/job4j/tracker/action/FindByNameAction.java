package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;

import java.util.List;

import static ru.job4j.tracker.StartUI.showInfoItem;

public class FindByNameAction implements UserAction{
    private final Output output;

    public FindByNameAction (Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "Вывод заявок по имени";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String name = input.askStr("Введите имя: ");
        List<Item> items = store.findByName(name);
        if (!items.isEmpty()) {
            for (Item item : items) {
                showInfoItem(output, item);
            }
        } else {
            output.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
