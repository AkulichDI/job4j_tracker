package ru.job4j.tracker;




public class StartUI {
    private static void showInfoItem(Item item){
        System.out.println("Ссылка на объект: " + item);
        System.out.println("Заголовок: " + item.getName());
        System.out.println("ID записи: " + item.getId());
        System.out.println("============================");
    }
    public static  void  createItem(Input input, Tracker tracker){
        System.out.println("==== Создание новой заявки ====");
        String name = input.askStr("Введите наименование\n");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка");
        showInfoItem(item);
    }

    public static void deleteItem(Input input, Tracker tracker) {
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
    }
    public static void findAllItems(Tracker tracker) {
        System.out.println("==== Вывод всех заявок ====");
        Item[] items = tracker.findAll();
        if (items.length>0) {
            for (Item item : items) {
                showInfoItem(item);
            }
        }else {
            System.out.println("Хранилище еще не содержит заявок");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
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
    }

    public static void findItemById(Input input, Tracker tracker) {
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
    }

    public static void replaceItem(Input input, Tracker tracker) {
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
    }
    
    public void init(Input input, Tracker tracker) {
       boolean run = true;
       while (run) {
           showMenu();
           System.out.println();
           int select = input.askInt("Выбрать: ");
           if (select == 0 ){
               createItem(input, tracker);
           } else if (select == 1 ) {
               findAllItems(tracker);
           } else if (select == 2) {
               replaceItem(input, tracker);
           } else if (select == 3 ) {
               deleteItem(input, tracker);
           } else if (select == 4 ) {
               findItemById(input, tracker);
           }else if (select == 5 ) {
               findItemByName(input, tracker);
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
