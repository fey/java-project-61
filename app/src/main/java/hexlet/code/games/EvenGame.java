package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import org.apache.commons.lang3.RandomUtils;

public class EvenGame {
    public static void runGame() {
        var description = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        var rounds = new GameRound[Engine.ROUNDS_COUNT];

        for (var i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            rounds[i] = buildRound();
        }

        Engine.runGame(description, rounds);
    }
    static GameRound buildRound() {
        final int min = 1;
        final int max = 100;
        var number = RandomUtils.nextInt(min, max);
        var isEven = number % 2 == 0;
        var question = Integer.toString(number);
        var answer = isEven ? "yes" : "no";

        return new GameRound(question, answer);
    }
}

