package ru.job4j.tracker.action;

import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;

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
    public boolean execute(Input input, MemTracker memTracker) {
        boolean run3 = true;
        while (run3) {
            int id = input.askInt("Введите id: ");
            if (null != memTracker.findById(id)) {
                Item item = memTracker.findById(id);
                memTracker.delete(id);
                output.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                run3 = false;
            }else {
                output.println("Запись " + id + "отсутствует");
            }
        }
        return true;
    }
}
