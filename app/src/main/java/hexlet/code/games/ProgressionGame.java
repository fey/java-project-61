package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameRound;
import org.apache.commons.lang3.RandomUtils;

import java.util.StringJoiner;

public class ProgressionGame {
    public static void runGame() {
        var description = "What number is missing in the progression?";
        var rounds = new GameRound[Engine.ROUNDS_COUNT];

        for (var i = 0; i < Engine.ROUNDS_COUNT; i += 1) {
            rounds[i] = buildRound();
        }

        Engine.runGame(description, rounds);
    }

    static int[] buildProgression(int first, int step, int length) {
        var progression = new int[length];

        for (var i = 0; i < length; i += 1) {
            progression[i] = first + step * i;
        }

        return progression;
    }

    static String buildQuestion(int[] progression, int hiddenIndex) {
        var joiner = new StringJoiner(" ");

        for (var i = 0; i < progression.length; i += 1) {
            var element = i == hiddenIndex ? ".." : Integer.toString(progression[i]);
            joiner.add(element);
        }

        return joiner.toString();
    }
    static GameRound buildRound() {
        var length = 10;
        var min = 1;
        var max = 10;
        var firstElement = RandomUtils.nextInt(min, max);
        var step = RandomUtils.nextInt(min, max);
        var hiddenIndex = RandomUtils.nextInt(0, length - 1);
        var progression = buildProgression(firstElement, step, length);
        var question = buildQuestion(progression, hiddenIndex);
        var answer = Integer.toString(progression[hiddenIndex]);

        return new GameRound(question, answer);
    }
}
