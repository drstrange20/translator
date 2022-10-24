package ru.mysite.translator;

import java.util.Scanner;

public class Translator {

    static Scanner scannerString = new Scanner(System.in);
    static int numberOfWords;

    public static void translate(String[] firstArray, String[] secondArray) {
        int counter = 1;
        int rightAnswers = 0;
        int wrongAnswers = 0;

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
                rightAnswers++;
            } else {
                System.out.println("К сожалению, Вы ошиблись!\nПравильный ответ: " + secondArray[i]);
                wrongAnswers++;
            }
            counter++;
        }
        System.out.println("Количество правильных ответов: " + rightAnswers + "\nКоличество неправильных ответов: " + wrongAnswers + ".");
        playAgain();
    }

    static void playAgain() {
        System.out.println("\nХотите сыграть еще раз?\nНапишите: \"да\" или \"нет\":");

        String answer = scannerString.nextLine();
        while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет")) {
            System.out.println("\nНекорректный ответ.");
            answer = scannerString.nextLine();
        }
        if (answer.equalsIgnoreCase("нет")) {
            System.out.println("\nСпасибо за игру!\nВозвращайтесь скорее! Будем тренировать Ваш Английский!");
        } else {
            chooseLanguage();
        }
    }

    static void chooseLanguage() {
        final String[] ENGLISH_WORDS = {"redundant", "variable", "property", "versatile", "maintenance", "explanation", "response", "particular", "precise", "fiddle"};
        final String[] RUSSIAN_WORDS = {"излишний", "переменная", "свойство", "многофункциональный", "поддержка", "объяснение", "ответ", "частный", "точный", "играть"};

        System.out.println("\nНа какой язык хотите переводить на русский или на английский?\nНапишите \"рус\" или \"eng\"");
        String answer = scannerString.nextLine();
        while (!answer.equalsIgnoreCase("рус") && !answer.equalsIgnoreCase("eng")) {
            System.out.println("\nНекорректный ответ.");
            answer = scannerString.nextLine();
        }
        if (answer.equalsIgnoreCase("eng")) {
            translate(RUSSIAN_WORDS, ENGLISH_WORDS);
        } else {
            translate(ENGLISH_WORDS, RUSSIAN_WORDS);
        }
    }

    static int chooseHowMuchWordsToTranslate(int englishLength) {
        Scanner scannerInteger = new Scanner(System.in);
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

    //static String verifyUserName() {
//        name = scannerString.nextLine();
//
//        while (name == null || name.trim().isEmpty()) {
//
//            System.out.println("Вы ввели некорректное имя");
//
//            name = scannerString.nextLine();
//        }
//        return name;
//    }
}