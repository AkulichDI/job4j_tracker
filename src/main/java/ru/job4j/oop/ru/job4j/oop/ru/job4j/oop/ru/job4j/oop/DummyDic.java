package ru.job4j.oop.ru.job4j.oop.ru.job4j.oop.ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng){
        return "Неизвестное слово. " + eng;
    }
    public static void main(String[] args) {
        DummyDic kukripulas = new DummyDic();
        String word = kukripulas.engToRus("хаф уаф уа");
        System.out.println(word);
    }
}
