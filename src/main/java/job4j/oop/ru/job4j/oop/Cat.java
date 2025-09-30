package job4j.oop.ru.job4j.oop;

public class Cat {
    private String food;
    private String name;
    public void giveNick(String nick){
        this.name = nick;
    }
    public void show() {
        System.out.println("Котик по имени: " + this.name);
        System.out.println(this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }
    public String sound() {
        String voice = "may-may";
        return voice;
    }
        public static void main(String[] args) {

          /*  Cat peppy = new Cat();
            Cat sparky = new Cat();
            String say = peppy.sound();
            System.out.println("Peppy says " + say);*/

            System.out.println("There is gav's food.");
            Cat gav = new Cat();
            gav.giveNick("Gav");
            gav.eat("cutlet");
            gav.show();
            System.out.println("There is black's food.");
            Cat black = new Cat();
            black.giveNick("Black");
            black.eat("fish");
            black.show();

        }

}
