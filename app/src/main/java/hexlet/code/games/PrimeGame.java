package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class PrimeGame {
    public static void runGame() {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        var roundsCount = 3;
        System.out.println(description);
        for (var i = 1; i <= roundsCount; i += 1) {
            var round = buildRound();
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

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (var i = 2; i <= Math.sqrt(number); i += 1) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
    static GameRound buildRound() {
        var number = RandomUtils.nextInt(1, 50);
        var question = Integer.toString(number);
        var answer = isPrime(number) ? "yes" : "no";

        return new GameRound(question, answer);
    }
}
