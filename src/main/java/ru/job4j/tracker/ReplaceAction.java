package ru.job4j.tracker;

import static ru.job4j.tracker.StartUI.showInfoItem;

public class ReplaceAction implements UserAction{
    private final Output output;

    public ReplaceAction (Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "Редактирование заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean run2 = true;
        while (run2) {
            int id = input.askInt("Введите id:");
            if (null != tracker.findById(id)) {
                String name = input.askStr("Введите имя: ");
                Item item = new Item(name);
                showInfoItem(item);
                tracker.replace(id, item);
                output.println("Заявка изменена успешно.");
                run2 = false;
            } else {
                output.println("Запись " + id + "отсутствует");
            }
        };
        return true;
    }
}
