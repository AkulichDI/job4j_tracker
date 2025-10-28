package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class Tracker {
    //private final Item[] items = new Item[100];
    private int ids = 1;
    ArrayList<Item> items = new ArrayList<>();



    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }
    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items.add(index,item);
        return true;
    }
    public boolean delete (int id){
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
//        System.arraycopy(items, index + 1, items, index, items.size() - index - 1);
//        items[size - 1] = null;
//        size--;
        return true;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public Item[] findByName(String key){
        int counter = 0;
        ArrayList<Item> itemsSh = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(key) ){
                itemsSh.set(counter, items.get(i));
                counter++;
            }
        }

        return Arrays.copyOf(itemsSh, counter);
    }

    public Item[] findAll(){
        return Arrays.copyOf(items, items.size());
    }


    public static String text(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(text());
        System.out.println(text("aaa"));
        System.out.println(text("aaa", "bbb", "ccc"));
        System.out.println(text("aaa", "bbb", "ccc", "ddd", "eee"));
    }

}