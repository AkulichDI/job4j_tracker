package job4j.oop.ru.job4j.oop;

public class Truck extends Vehicle {

    @Override
    public void accelerate() {
        System.out.println("Электронная педаль газа");
    }
    @Override
    public void steer() {
        System.out.println("Стандартное рулевое управление");
    }

    @Override
    public void poslatnaf(){
        System.out.println("Это моя машина!");
    }
}
