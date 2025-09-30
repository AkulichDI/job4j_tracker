package job4j.moreHWAI;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books = new ArrayList<>();
    public void sayMName(){
        System.out.println(this.name);
    }
    public Library(String name){
        this.name = name;
    }
    public void addBook (String title, String author){

        Book book   = new Library.Book(title, author);
    }
    public String getName() {
        return name;
    }

    public void showBooks(){
        for (Book name : books){
            name.sayInfo();
        }
    }

        private static class Book{
        String title;
        String author;
        public Book(String java, String s) {
            this.title = java;
            this.author = s;
        }
        public void sayInfo(){
            System.out.println("Наименование: " + this.title + ", Автор: " + this.author );
        }
    }
    public static void main(String[] args) {
        Library hog = new Library("Наименование библ");
        hog.sayMName();
        hog.addBook("jAVA", "KUKRIPULAZ");
        hog.showBooks();

    }
}
