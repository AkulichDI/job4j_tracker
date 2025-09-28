package ru.job4j.oop.ru.job4j.oop;

import javax.swing.text.Style;

public class Student {

    public void music() {
        System.out.println("Tra tra tra");
    }

    public void sing(){
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {

        Student petya = new Student();
        petya.sing();
        petya.sing();
        petya.sing();
        petya.music();
        petya.music();
        petya.music();
    }



}
