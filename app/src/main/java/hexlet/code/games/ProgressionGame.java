package hexlet.code.games;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class ProgressionGame {
    public static void runGame() {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");

        var description = "What number is missing in the progression?";

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
        var firstElement = RandomUtils.nextInt(1, 10);
        var step = RandomUtils.nextInt(1, 10);
        var hiddenIndex = RandomUtils.nextInt(0, length - 1);
        var progression = buildProgression(firstElement, step, length);
        var question = buildQuestion(progression, hiddenIndex);
        var answer = Integer.toString(progression[hiddenIndex]);

        return new GameRound(question, answer);
    }
}
