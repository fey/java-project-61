package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class GcdGame {
    public static void runGame() {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        var description = "Find the greatest common divisor of given numbers.";

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

    static int findGcd(int first, int second) {
        return second == 0 ? first : findGcd(second, first % second);
    }
    static GameRound buildRound() {
        var number1 = RandomUtils.nextInt(1, 50);
        var number2 = RandomUtils.nextInt(1, 50);
        var gcd = findGcd(number1, number2);
        var question = number1 + " " + number2;
        var answer = Integer.toString(gcd);

        return new GameRound(question, answer);
    }
}
