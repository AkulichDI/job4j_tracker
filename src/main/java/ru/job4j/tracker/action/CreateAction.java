package ru.job4j.tracker.action;


import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.output.Output;

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
    public boolean execute(Input input, Store store) {
        output.println("==== Создание новой заявки ====");
        String name = input.askStr("Введите наименование\n");
        Item item = new Item(name);
        store.add(item);
        output.println("Добавлена заявка");
       return true;
    }


}
