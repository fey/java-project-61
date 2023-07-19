package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class CalcGame {
    public static void runGame() {
        var description = "What is the result of the expression?";
        var rounds = new GameRound[Engine.ROUNDS_COUNT];

        for (var i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            rounds[i] = buildRound();
        }

        Engine.runGame(description, rounds);
    }
    static GameRound buildRound() {
        String[] operations = {"+", "-", "*"};
        final var min = 1;
        final var max = 20;
        var operationIndex = new Random().nextInt(operations.length);
        var operation = operations[operationIndex];
        var number1 = RandomUtils.nextInt(min, max);
        var number2 = RandomUtils.nextInt(min, max);
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
