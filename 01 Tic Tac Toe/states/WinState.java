package states;

import models.Board;
import models.Symbol;

public class WinState extends State {
    private Symbol currentPlayer;
    private Symbol nextPlayer;
    private Board board;

    public WinState(Symbol currentPlayer, Symbol nextPlayer, Board board) {
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
        this.board = board;
    }

    @Override
    public void execute() {
        if(board.hasWinner()) {
            System.out.println(board);
            System.out.println();
            System.out.println("Player " + currentPlayer + " wins the game!");
        } else {
            context.transitionTo(new TieState(nextPlayer, board));
            context.execute();
        }
    }
}