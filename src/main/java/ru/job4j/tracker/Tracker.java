package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    private int ids = 1;
    private final List<Item> items = new ArrayList<>();



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
        items.set(index,item);
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

    public List<Item> findByName(String key){
        List<Item> itemsSh = new ArrayList<>();

        for (Item it : items){
            if (it.getName().equals(key)){
                itemsSh.add(it);
            }
        }
        return itemsSh;
//
//        for (int i = 0; i < items.size(); i++) {
//            if(items.get(i).getName().equals(key) ){
//                itemsSh.set(counter, items.get(i));
//                counter++;
//            }
//        }
//
//        return Arrays.copyOf(itemsSh, counter);
    }

    public List<Item> findAll(){
        return new ArrayList<>(items);
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