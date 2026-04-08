package ru.job4j.tracker.action;

import ru.job4j.tracker.Store;
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
        return "РЈРґР°Р»РµРЅРёРµ Р·Р°СЏРІРєРё";
    }

    @Override
    public boolean execute(Input input, Store store) {
        boolean run3 = true;
        while (run3) {
            int id = input.askInt("Введите id: ");
            if (null != store.findById(id)) {
                Item item = store.findById(id);
                store.delete(id);
                output.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                run3 = false;
            }else {
                output.println("Запись " + id + "отсутствует");
            }
        }
        return true;
    }
}
