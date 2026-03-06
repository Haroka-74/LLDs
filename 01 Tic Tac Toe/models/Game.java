package models;

import states.Context;
import states.PlayingState;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void run() {
        new Context(new PlayingState(board, player1, player2)).execute();
    }
}