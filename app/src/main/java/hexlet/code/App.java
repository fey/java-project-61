package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        final var menuItemGreet = 1;
        final var menuItemEven = 2;
        final var menuItemCalc = 3;
        final var menuItemGCD = 4;
        final var menuItemProgression = 5;
        final var menuItemPrime = 6;

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(menuItemGreet + " - Greet");
        System.out.println(menuItemEven + " - Even");
        System.out.println(menuItemCalc + " - Calc");
        System.out.println(menuItemGCD + " - GCD");
        System.out.println(menuItemProgression + " - Progression");
        System.out.println(menuItemPrime + " - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        var chooseMenuItem = Integer.parseInt(scanner.next());

        switch (chooseMenuItem) {
            case menuItemGreet -> greeting();
            case menuItemEven -> EvenGame.runGame();
            case menuItemCalc -> CalcGame.runGame();
            case menuItemGCD -> GcdGame.runGame();
            case menuItemProgression -> ProgressionGame.runGame();
            case menuItemPrime -> PrimeGame.runGame();
            default -> System.exit(0);
        }
    }

    public static void greeting() {
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("What is your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }
}
