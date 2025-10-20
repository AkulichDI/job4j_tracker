package ru.job4j.tracker;



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
