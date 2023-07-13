package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        var scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }
}
