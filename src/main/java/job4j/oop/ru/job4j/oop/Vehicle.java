package job4j.oop.ru.job4j.oop;

public abstract class Vehicle {
    private String brand;
    private String model;
    private String type;
    private int passengers;
    private int maxSpeed;

    public abstract void accelerate();
    public abstract void steer();
    public abstract void poslatnaf();

    public void brake() {
        System.out.println("Стандартная тормозная система");

    }
}
