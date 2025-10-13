package job4j.cast;

import job4j.polymorphism.Transport;

public class Main {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle plain = new Plain();
        Vehicle train = new Train();
        Vehicle[] transport = {bus, plain, train};

        for (Vehicle vehicle : transport) {
            vehicle.move();
            vehicle.sound();
        }
    }
}
