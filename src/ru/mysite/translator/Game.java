package ru.mysite.translator;

import java.util.Scanner;

class Game {
    static final String[] ENGLISH_WORDS = {"redundant", "hyperlink", "archive", "debug", "issue", "encrypt", "decrypt", "exception", "verify", "disable", "enable", "equal", "from scratch", "capability", "request", "gateway"};
    static final String[] RUSSIAN_WORDS = {"излишний", "ссылка", "архивировать", "отлаживать", "проблема", "зашифровывать", "расшифровывать", "исключение", "проверять", "запрещать", "разрешать", "равный", "с нуля", "возможности", "запрос", "шлюз"};
    static Scanner scannerInteger = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);
    static int numberOfWords;
    static String name;

    public static void translate(String[] firstArray, String[] secondArray) {

        int counter = 1;

        System.out.println("\nСколько слов Вы хотите перевести?\nВведите число от 1 до " + firstArray.length + ":");
        numberOfWords = chooseHowMuchWordsToTranslate(firstArray.length);

        for (int i = 0; i < firstArray.length; i++) {
            int index = (int) (Math.random() * firstArray.length);

            String first = firstArray[i];
            firstArray[i] = firstArray[index];
            firstArray[index] = first;

            String second = secondArray[i];
            secondArray[i] = secondArray[index];
            secondArray[index] = second;
        }

        for (int i = 0; i < numberOfWords; i++) {

            System.out.println("\n" + counter + ". " + firstArray[i]);

            String translate = scannerString.nextLine();

            if (translate.equalsIgnoreCase(secondArray[i])) {
                System.out.println("Верно!");
            } else {
                System.out.println("К сожалению, Вы ошиблись!\nПравильный ответ: " + secondArray[i]);
            }
            counter++;
        }
        playAgain();
    }

    static void playAgain() {
        System.out.println("\nХотите сыграть еще раз?\nВведите \"да\" или \"нет\":");

        String answer = scannerString.nextLine();
        while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет")) {
            System.out.println("\nНекорректный ответ.");
            answer = scannerString.nextLine();
        }
        if (answer.equalsIgnoreCase("нет")) {
            System.out.println("\nСпасибо за игру, " + name + "!\nВозвращайтесь скорее! Будем тренировать Ваш Английский!");
        } else {
            chooseLanguage(name);
        }
    }

    static void chooseLanguage(String name) {
        System.out.println("\n" + name + ", на какой язык хотите переводить?\nНапишите \"на русский\" или \"на английский\":");

        String answer = scannerString.nextLine();
        while (!answer.equalsIgnoreCase("на русский") && !answer.equalsIgnoreCase("на английский")) {
            System.out.println("\nНекорректный ответ.");
            answer = scannerString.nextLine();
        }
        if (answer.equalsIgnoreCase("на английский")) {
            translate(RUSSIAN_WORDS, ENGLISH_WORDS);
        } else {
            translate(ENGLISH_WORDS, RUSSIAN_WORDS);
        }
    }

    static int chooseHowMuchWordsToTranslate(int englishLength) {
        while (true) {
            try {
                numberOfWords = Integer.parseInt(scannerInteger.nextLine().trim());
                while (numberOfWords < 1 || numberOfWords > englishLength) {
                    System.out.println("Введите число от 1 до " + englishLength + ":");
                    numberOfWords = Integer.parseInt(scannerInteger.nextLine().trim());
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введите число от 1 до " + englishLength + ":");
            }
        }
        return numberOfWords;
    }

    static String verifyUserName() {
        name = scannerString.nextLine();

        while (name == null || name.trim().isEmpty()) {

            System.out.println("Вы ввели некорректное имя");

            name = scannerString.nextLine();
        }
        return name;
    }
}