package ru.job4j.tracker;




public class StartUI {
    private void showInfoItem(Item item){
        System.out.println("Ссылка на объект: " + item);
        System.out.println("Заголовок: " + item.getName());
        System.out.println("ID записи: " + item.getId());
        System.out.println("============================");
    }
    public void init(Input input, Tracker tracker) {
       boolean run = true;
       while (run) {
           showMenu();
           System.out.println();
           int select = input.askInt("Выбрать: ");
           if (select == 0 ){
               System.out.println("==== Создание новой заявки ====");
               String name = input.askStr("Введите наименование\n");
               Item item = new Item(name);
               tracker.add(item);
               System.out.println("Добавлена заявка");
               showInfoItem(item);
           } else if (select == 1 ) {
               System.out.println("==== Вывод всех заявок ====");
               Item[] items = tracker.findAll();
               if (items.length>0) {
                   for (Item item : items) {
                       showInfoItem(item);
                   }
               }else {
                   System.out.println("Хранилище еще не содержит заявок");
               }

           } else if (select == 2) {
               boolean run2 = true;
               while (run2) {
                   System.out.println("=== Редактирование заявки ===");

                   int id = input.askInt("Введите id:");
                   if (null != tracker.findById(id)) {
                       String name = input.askStr("Введите имя: ");
                       Item item = new Item(name);
                       showInfoItem(item);
                       tracker.replace(id, item);
                       System.out.println("Заявка изменена успешно.");
                       run2 = false;
                   } else {
                       System.out.println("Запись " + id + "отсутствует");
                   }
               }
           } else if (select == 3 ) {
               boolean run3 = true;
               while (run3) {
                   System.out.println("=== Удаление заявки ===");
                   int id = input.askInt("Введите id: ");
                   if (null != tracker.findById(id)) {
                       Item item = tracker.findById(id);
                       showInfoItem(item);
                       tracker.delete(id);
                       System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                       run3 = false;
                   }else {
                       System.out.println("Запись " + id + "отсутствует");
                   }
               }
           } else if (select == 4 ) {
                boolean run4 = true;
                while (run4) {
                    System.out.println("=== Вывод заявки по id ===");
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
           }else if (select == 5 ) {
               System.out.println("=== Вывод заявок по имени ===");
               String name = input.askStr("Введите имя: ");
               Item[] items = tracker.findByName(name);
               if (items.length > 0) {
                   for (Item item : items) {
                       showInfoItem(item);
                   }
               } else {
                   System.out.println("Заявки с именем: " + name + " не найдены.");
               }
           } else {
               run = false;
           }
       }


    }
    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки",
                "Изменить заявку", "Удалить заявку", "Показать заявку по id",
                "Показать заявки по имени", "Завершить программу"};
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i+". "+ menu[i]);

        }
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);



    }
}
