package models;

import utils.Console;

public class AI extends Player {

    public AI(Symbol symbol) {
        super("AI", symbol);
    }

    @Override
    public Position move(Board board) {
        Console.clear();
        System.out.println(board);
        System.out.println();
        System.out.println("AI is thinking...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                var position = new Position(i, j);
                if(board.validate(position)) {
                    return position;
                }
            }
        }
        return null;
    }
}