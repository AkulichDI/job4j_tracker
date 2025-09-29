package ru.job4j.oop.ru.job4j.oop;

public class Calculator {
    private static int x = 5;
    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y){
        return y - x;
    }

    public int divide(int y){
        return y / Calculator.x;
    }
    public int sumAllOperation(int y){
        return sum(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator first = new Calculator();
        int result = Calculator.sum(10);
        System.out.println(result);
        result = minus(5);
        System.out.println(result);
        result = first.divide(5);
        System.out.println(result);
        result = first.sumAllOperation(5);
        System.out.println(result);

    }

}
