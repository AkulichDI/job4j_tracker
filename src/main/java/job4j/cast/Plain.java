package job4j.cast;

public class Plain implements Vehicle{
    @Override
    public void move() {
        System.out.println("Едем вперед");
    }

    @Override
    public void sound() {
        System.out.println("wooow");
    }
}
