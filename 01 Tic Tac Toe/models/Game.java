package models;

import states.Context;
import states.PlayingState;

public class Game {
    private Symbol currentPlayer;
    private Board board;

    public Game() {
        currentPlayer = Symbol.X;
        board = new Board();
    }

    public void run() {
        new Context(new PlayingState(currentPlayer, board)).execute();
    }
}