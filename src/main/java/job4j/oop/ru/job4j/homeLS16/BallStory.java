package job4j.oop.ru.job4j.homeLS16;


import job4j.oop.ru.job4j.oop.Wolf;

public class BallStory {

    public static void main(String[] args) {

        Ball ball = new Ball();
        Wolf wolf = new Wolf();
        Hare hare = new Hare();
        Fox  fox  = new Fox();
        hare.tryEat(ball);
      //  wolf.tryEat(ball);
        fox.tryEat(ball);


    }

}
