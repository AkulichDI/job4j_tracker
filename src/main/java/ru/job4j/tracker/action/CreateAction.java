package ru.job4j.tracker.action;


import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name(){
       return "Добавить новую запись";
   }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("==== Создание новой заявки ====");
        String name = input.askStr("Введите наименование\n");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавлена заявка");
       return true;
    }


}
