package ru.job4j.tracker;

import static ru.job4j.tracker.StartUI.showInfoItem;

public class FindByIdAction implements UserAction{
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
                    showInfoItem(item);
                } else {
                    System.out.println("Заявка с введенным id: " + id + " не найдена.");
                }
                run4 = false;
            }else {
                System.out.println("Запись " + id + "отсутствует");
            }

        }
        return true;
    }
}
