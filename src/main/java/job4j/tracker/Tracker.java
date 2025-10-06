package job4j.tracker;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }
    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }
    public boolean replace (int id, Item item){
        int  index = indexOf(id);
        boolean result  = index != 1;
        if (result){
        item.setId(id);
        items[index] = item;}
        return true;
    }
    public boolean delete (int id){
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[size - 1] = null;
        size--;
        return true;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key){
        int counter = 0;
        Item[] itemsSh = new Item[100];
        for (int i = 0; i < size; i++) {
            if(items[i].getName().equals(key) ){
                itemsSh[counter] = items[i];
                counter++;
            }
        }
        return Arrays.copyOf(itemsSh, counter);
    }

    public Item[] findAll(){
        return Arrays.copyOf(items, size);
    }




}