package job4j.io;

import java.util.Scanner;

public class Matches {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Игра 11.");
            boolean turn = true;
            int count = 11;
            int t;
            while (count > 0) {
                t = count>=3?3:count;
                String player = turn ? "Первый игрок" : "Второй игрок";
                System.out.println(player + " введите число от 1 до " + t);
                int matches = Integer.parseInt(input.nextLine());
                if (matches <=3 && matches>0){
                    if (matches<= count){
                        count -= matches;
                        turn = !turn;
                    }else {
                        System.out.println("Осталось: "+count);
                    }
                }else {
                    System.out.println("Число: " + matches + " не подходит\nВведите число от 1 до 3.");
                }
            }
            if (!turn) {
                System.out.println("Выиграл первый игрок");
            } else {
                System.out.println("Выиграл второй игрок");
            }
        }
}



