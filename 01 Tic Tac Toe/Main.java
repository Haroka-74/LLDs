import models.Game;
import models.Player;
import models.Symbol;
import utils.Console;
import java.util.Scanner;
import strategies.AIMove;
import strategies.HumanMove;

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

                player1 = new Player(x, Symbol.X, new HumanMove());
                player2 = new Player(o, Symbol.O, new HumanMove());
            }
            case "2" -> {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine().trim();

                player1 = new Player(name, Symbol.X, new HumanMove());
                player2 = new Player("AI", Symbol.O, new AIMove());
            }
            default -> {
                System.out.println("Invalid option, starting Player vs. Player by default");
                player1 = new Player("Player 1", Symbol.X, new HumanMove());
                player2 = new Player("Player 2", Symbol.O, new HumanMove());
            }
        }

        new Game(player1, player2).run();
    }
}