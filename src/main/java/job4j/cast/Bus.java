package job4j.cast;

public class Bus implements Vehicle {


    @Override
    public void move() {
        System.out.println("Move");
    }

    @Override
    public void sound() {
        System.out.println("Бип");
    }
}
