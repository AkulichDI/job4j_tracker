package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Вывод всех заявок ====");
        Item[] items = tracker.findAll();
        if (items.length>0) {
            for (Item item : items) {
                showInfoItem(item);
            }
        }else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
