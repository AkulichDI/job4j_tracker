package job4j.polymorphism;

public class Bus implements Transport{
    @Override
    public void move() {
        System.out.println("Автобус передвигается");
    }

    @Override
    public void passengers(int count) {
        int maxPass = 40;
        if (maxPass <= count){
            System.out.println("В автобус все вместились.\nВ автобусе " + count + "пассажиров");
        }else {
            System.out.println("В автобусе нет мест.");
        }

    }

    @Override
    public int refuel(int fuel) {
        double priceOneL = 54.3;
        return (int) (priceOneL * fuel);
    }


}
