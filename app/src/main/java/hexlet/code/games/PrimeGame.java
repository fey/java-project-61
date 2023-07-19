package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import org.apache.commons.lang3.RandomUtils;

public class PrimeGame {
    public static void runGame() {
        var description = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        var rounds = new GameRound[Engine.ROUNDS_COUNT];

        for (var i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            rounds[i] = buildRound();
        }

        Engine.runGame(description, rounds);
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
        var min = 1;
        var max = 50;
        var number = RandomUtils.nextInt(min, max);
        var question = Integer.toString(number);
        var answer = isPrime(number) ? "yes" : "no";

        return new GameRound(question, answer);
    }
}
