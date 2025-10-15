package ru.job4j.tracker;



public class CreateAction implements UserAction {
   @Override
    public String name(){
       return "Добавить новую запись";
   }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Создание новой заявки ====");
        String name = input.askStr("Введите наименование\n");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка");
       return true;
    }


}
