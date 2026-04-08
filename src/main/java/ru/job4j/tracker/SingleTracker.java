package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private final MemTracker memTracker = new MemTracker();
    private static SingleTracker instance = null;

    private SingleTracker(){
    }


    public static SingleTracker getInstance() {
        if (instance == null){
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add (Item item) {
        return memTracker.add(item);
    }
    public List<Item> findByName(String name){
        return memTracker.findByName(name);
    }
    public boolean delete (int id){
        return memTracker.delete(id);
    }
    public Item findById (int id ){
        return memTracker.findById(id);
    }
    public List<Item> findAll(){
        return memTracker.findAll();
    }
    public boolean replace(int id, Item item){
        return memTracker.replace(id, item);
    }

}
