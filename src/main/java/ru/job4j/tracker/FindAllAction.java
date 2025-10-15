package ru.job4j.tracker;

import static ru.job4j.tracker.StartUI.showInfoItem;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Вывод всех заявок ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Вывод всех заявок ====");
        Item[] items = tracker.findAll();
        if (items.length>0) {
            for (Item item : items) {
                showInfoItem(item);
            }
        }else {
            System.out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
