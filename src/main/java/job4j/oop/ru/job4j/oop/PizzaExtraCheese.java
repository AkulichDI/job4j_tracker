package job4j.oop.ru.job4j.oop;

public class PizzaExtraCheese extends Pizza{

    @Override
    public String name(){
        return super.name() + " extra cheese";
    }
}
