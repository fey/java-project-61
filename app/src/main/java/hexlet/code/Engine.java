package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;
    public static void runGame(String description, GameRound[] rounds) {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println(description);

        for (var round : rounds) {
            System.out.println("Question: " + round.getQuestion());
            System.out.print("Your answer: ");
            var answer = round.getAnswer();
            var userAnswer = scanner.next();

            if (!answer.equals(userAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + answer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
            System.out.println("Correct!");

        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
