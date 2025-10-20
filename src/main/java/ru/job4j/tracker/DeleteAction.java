package ru.job4j.tracker;

import static ru.job4j.tracker.StartUI.showInfoItem;

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
                showInfoItem(item);
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
