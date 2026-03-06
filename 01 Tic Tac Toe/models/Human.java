package models;

import utils.Console;
import java.util.Scanner;

public class Human extends Player {
    private static final Scanner scanner = new Scanner(System.in);

    public Human(String name, Symbol symbol) {
        super(name, symbol);
    }

    @Override
    public Position move(Board board) {
        while(true) {
            System.out.println(board);
            System.out.println();
            System.out.print(name + ", enter row and column (1-3) separated by space: ");

            var input = scanner.nextLine().trim();
            var parts = input.split("\\s+");

            if(parts.length < 2) {
                Console.clear();
                System.out.println("Invalid input!");
                continue;
            }

            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;

            if(!board.validate(new Position(row, col))) {
                Console.clear();
                System.out.println("Invalid move!");
            } else {
                return new Position(row, col);
            }
        }
    }
}