package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.Scanner;

public class CalcGame {
    public static void runGame() {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        var description = "What is the result of the expression?";

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
    static GameRound buildRound() {
        String[] operations = {"+", "-", "*"};
        var operationIndex = new Random().nextInt(operations.length);
        var operation = operations[operationIndex];
        var number1 = RandomUtils.nextInt(1, 20);
        var number2 = RandomUtils.nextInt(1, 20);
        var question = number1 + " " + operation + " " + number2;
        var answer = Integer.toString(calculate(operation, number1, number2));

        return new GameRound(question, answer);
    }

    static int calculate(String operation, int n1, int n2) {
        switch (operation) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            default:
                System.err.println("Unknown operation");
                System.exit(1);
                return 0;
        }
    }
}
