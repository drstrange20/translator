package main.java;

public class Program {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Переводчик!\nВведите Ваше имя:");
        String name = Game.userName();

        Game.chooseLanguage(name);
    }
}
