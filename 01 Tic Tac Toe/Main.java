import models.AI;
import models.Game;
import models.Human;
import models.Player;
import models.Symbol;
import utils.Console;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Console.clear();
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("-----------------------");
        System.out.println("1. Player vs. Player");
        System.out.println("2. Player vs. AI");
        System.out.print("Choose an option: ");

        var choice = scanner.nextLine().trim();

        Player player1, player2;

        switch (choice) {
            case "1" -> {
                System.out.print("Enter name for X player: ");
                String x = scanner.nextLine().trim();

                System.out.print("Enter name for O player: ");
                String o = scanner.nextLine().trim();

                player1 = new Human(x, Symbol.X);
                player2 = new Human(o, Symbol.O);
            }
            case "2" -> {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine().trim();

                player1 = new Human(name, Symbol.X);
                player2 = new AI(Symbol.O);
            }
            default -> {
                System.out.println("Invalid option, starting Player vs. Player by default");
                player1 = new Human("Player 1", Symbol.X);
                player2 = new Human("Player 2", Symbol.O);
            }
        }

        new Game(player1, player2).run();
    }
}