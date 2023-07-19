package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import org.apache.commons.lang3.RandomUtils;

public class GcdGame {
    public static void runGame() {
        var description = "Find the greatest common divisor of given numbers.";
        var rounds = new GameRound[Engine.ROUNDS_COUNT];

        for (var i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            rounds[i] = buildRound();
        }

        Engine.runGame(description, rounds);
    }

    static int findGcd(int first, int second) {
        return second == 0 ? first : findGcd(second, first % second);
    }
    static GameRound buildRound() {
        var min = 1;
        var max = 50;
        var number1 = RandomUtils.nextInt(min, max);
        var number2 = RandomUtils.nextInt(min, max);
        var gcd = findGcd(number1, number2);
        var question = number1 + " " + number2;
        var answer = Integer.toString(gcd);

        return new GameRound(question, answer);
    }
}
