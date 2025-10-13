package job4j.cast;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("GO");
    }

    @Override
    public void sound() {
        System.out.println("ekk");
    }
}
