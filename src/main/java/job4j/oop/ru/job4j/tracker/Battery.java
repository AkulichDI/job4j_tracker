package job4j.oop.ru.job4j.tracker;

public class Battery {
    private int load;
    private static int full = 100;
    public Battery(int load) {
        this.load = load;
    }
    public String about() {
        return "My charge: " + load + "%";
    }
    public void exchange(Battery another) {
        int total = this.load + another.load;
        if (total > full) {
            another.load = full;
            this.load = total - full;
        } else {
            another.load = total;
            this.load = 0;
        }
    }
    public static void main(String[] args) {

        Battery first = new Battery(100);

        Battery second = new Battery(30);

        System.out.println("First." + first.about());
        System.out.println("Second." + second.about());
        first.exchange(second);
        System.out.println("First." + first.about());
        System.out.println("Second." + second.about());
    }

}

