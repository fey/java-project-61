package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.*;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.print("Your choice: ");
        var chooseMenuItem = Integer.parseInt(scanner.next());

        switch (chooseMenuItem) {
            case 1 -> greeting();
            case 2 -> EvenGame.runGame();
            case 3 -> CalcGame.runGame();
            case 4 -> GcdGame.runGame();
            case 5 -> ProgressionGame.runGame();
            case 6 -> PrimeGame.runGame();
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
