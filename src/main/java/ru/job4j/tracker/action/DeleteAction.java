package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

public class DeleteAction implements UserAction{
    private final Output output;

    public DeleteAction (Output output) {
        this.output = output;
    }
    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean run3 = true;
        while (run3) {
            int id = input.askInt("Введите id: ");
            if (null != tracker.findById(id)) {
                Item item = tracker.findById(id);
                tracker.delete(id);
                output.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                run3 = false;
            }else {
                output.println("Запись " + id + "отсутствует");
            }
        }
        return true;
    }
}
