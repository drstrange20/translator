package ru.mysite.translator;

import java.util.Scanner;

class Game {
    static final String [] ENGLISH_WORDS = {"redundant", "expression", "software", "application", "freeware", "compile", "compress", "hyperlink", "archive", "debug", "issue", "encrypt", "decrypt", "exception", "verify", "disable", "taught", "tough", "though", "thorough", "enable", "thought", "equal", "through", "utility", "throughout", "from scratch", "capability", "request", "gateway"};
    static final String [] RUSSIAN_WORDS = {"излишний", "выражение", "програмное обеспечение", "приложение", "бесплатное ПО", "компилировать", "сжимать", "ссылка", "архивировать", "отлаживать", "проблема", "зашифровать", "расшифровывать", "исключение", "проверять", "запрещать", "учил", "жесткий", "хотя", "тщательный", "разрешать", "думал", "равный", "через", "утилита", "по всему", "с нуля", "возможности", "запрос", "шлюз"};
    static Scanner scanInt = new Scanner(System.in);
    static Scanner scanStr = new Scanner(System.in);

    public static void translateToEnglish(String name) {
        int russianLength = RUSSIAN_WORDS.length;
        int k = 1;

        System.out.println("\nСколько слов Вы хотите перевести?\nВведите число от 1 до " +russianLength + ":");
        int numberOfWords = howMatch(russianLength);


        for (int i = 0; i < russianLength; i++) {
            int index = (int) (Math.random()*russianLength);

            String rus = RUSSIAN_WORDS[i];
            RUSSIAN_WORDS[i] = RUSSIAN_WORDS[index];
            RUSSIAN_WORDS[index] = rus;

            String eng = ENGLISH_WORDS[i];
            ENGLISH_WORDS[i] = ENGLISH_WORDS[index];
            ENGLISH_WORDS[index] = eng;
        }

        for (int i = 0; i < numberOfWords; i++){

            System.out.println("\n" + k + ". " + RUSSIAN_WORDS[i]);

            String translate = scanStr.nextLine();

            if (translate.equalsIgnoreCase(ENGLISH_WORDS[i])){
                System.out.println("Верно!");
            } else {
                System.out.println("К сожалению, Вы ошиблись!\nПравильный ответ: " + ENGLISH_WORDS[i]);
            }
            k++;
        }
        playAgain(name);
    }

    public static void translateToRussian(String name) {
        int englishLength = ENGLISH_WORDS.length;
        int k = 1;

        System.out.println("\nCколько слов Вы хотите перевести?\nВведите число от 1 до " +englishLength + ":");
        int numberOfWords = howMatch(englishLength);


        for (int i = 0; i < englishLength; i++) {
            int index = (int) (Math.random()*englishLength);

            String eng = ENGLISH_WORDS[i];
            ENGLISH_WORDS[i] = ENGLISH_WORDS[index];
            ENGLISH_WORDS[index] = eng;

            String rus = RUSSIAN_WORDS[i];
            RUSSIAN_WORDS[i] = RUSSIAN_WORDS[index];
            RUSSIAN_WORDS[index] = rus;

        }

        for (int i = 0; i < numberOfWords; i++){

            System.out.println("\n" + k + ". " + ENGLISH_WORDS[i]);

            String translate = scanStr.nextLine();

            if (translate.equalsIgnoreCase(RUSSIAN_WORDS[i])){
                System.out.println("Верно!");
            } else {
                System.out.println("К сожалению, Вы ошиблись!\nПравильный ответ: " + RUSSIAN_WORDS[i]);
            }
            k++;
        }
        playAgain(name);
    }
    static void playAgain(String name) {
        System.out.println("\nХотите сыграть еще раз?\nВведите \"да\" или \"нет\":");

        String answer = scanStr.nextLine();
        while (!answer.equalsIgnoreCase("да") && !answer.equalsIgnoreCase("нет")) {
            System.out.println("\nНекорректный ответ.");
            answer = scanStr.nextLine();
        }
        if (answer.equalsIgnoreCase("нет")) {
            System.out.println("\nСпасибо за игру, " + name +"!\nВозвращайтесь скорее! Будем тренировать Ваш Английский!");
        } else {
            chooseLanguage(name);
        }
    }

    static void chooseLanguage(String name) {
        System.out.println("\n"+name + ", на какой язык хотите переводить?\nНапишите \"на русский\" или \"на английский\":");

        String answer = scanStr.nextLine();
        while (!answer.equalsIgnoreCase("на русский") && !answer.equalsIgnoreCase("на английский")) {
            System.out.println("\nНекорректный ответ.");
            answer = scanStr.nextLine();
        }
        if (answer.equalsIgnoreCase("на английский")) {
            translateToEnglish(name);
        } else {
            translateToRussian(name);
        }
    }

    static int howMatch(int englishLength) {
        int numberOfWords = scanInt.nextInt();
        while (numberOfWords < 1 || numberOfWords > englishLength) {

            System.out.println("Введите число от 1 до " +englishLength + ":");

            numberOfWords = scanInt.nextInt();
        }
        return numberOfWords;
    }
    static String userName(){
        String name = scanStr.nextLine();

        while (name == null || name.trim().isEmpty()) {

            System.out.println("Вы ввели некорректное имя");

            name = scanStr.nextLine();
        }
        return name;
    }
}
