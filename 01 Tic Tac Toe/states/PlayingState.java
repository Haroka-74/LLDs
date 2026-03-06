package states;

import models.Board;
import models.Symbol;
import utils.Console;
import java.util.Scanner;

public class PlayingState extends State {
    private static final Scanner scanner = new Scanner(System.in);

    private Symbol currentPlayer;
    private Board board;

    public PlayingState(Symbol currentPlayer, Board board) {
        this.currentPlayer = currentPlayer;
        this.board = board;
    }

    @Override
    public void execute() {
        Console.clear();

        int row, col;

        while(true) {
            System.out.println(board);
            System.out.println();
            System.out.print("Player " + currentPlayer + ", enter row and column (1-3) separated by space: ");

            var input = scanner.nextLine().trim();
            var parts = input.split("\\s+");

            if(parts.length < 2) {
                Console.clear();
                System.out.println("Invalid input!");
                continue;
            }

            row = Integer.parseInt(parts[0]) - 1;
            col = Integer.parseInt(parts[1]) - 1;

            if(!board.validate(row, col)) {
                Console.clear();
                System.out.println("Invalid move!");
                continue;
            } else {
                break;
            }
        }

        board.place(row, col, currentPlayer);
        Console.clear();

        var nextPlayer = currentPlayer == Symbol.X ? Symbol.O : Symbol.X;

        context.transitionTo(new WinState(currentPlayer, nextPlayer, board));
        context.execute();
    }
}