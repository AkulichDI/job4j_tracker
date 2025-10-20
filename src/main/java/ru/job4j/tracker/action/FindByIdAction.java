package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;

import static ru.job4j.tracker.StartUI.showInfoItem;

public class FindByIdAction implements UserAction{

    private final Output output;

    public FindByIdAction (Output output) {
        this.output = output;
    }



    @Override
    public String name() {
        return "Вывод заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        boolean run4 = true;
        while (run4) {
            int id = input.askInt("Введите id: ");
            if (null != tracker.findById(id)){
                Item item = tracker.findById(id);
                if (item != null) {
                    showInfoItem(output, item);
                } else {
                    output.println("Заявка с введенным id: " + id + " не найдена.");
                }
                run4 = false;
            }else {
                output.println("Запись " + id + "отсутствует");
            }

        }
        return true;
    }
}
