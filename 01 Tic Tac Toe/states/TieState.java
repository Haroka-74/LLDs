package states;

import models.Board;
import models.Symbol;

public class TieState extends State {
    private Symbol currentPlayer;
    private Board board;

    public TieState(Symbol currentPlayer, Board board) {
        this.currentPlayer = currentPlayer;
        this.board = board;
    }

    @Override
    public void execute() {
        if(board.isFull()) {
            System.out.println(board);
            System.out.println();
            System.out.println("It's a tie! Well played by both!");
        } else {
            context.transitionTo(new PlayingState(currentPlayer, board));
            context.execute();
        }
    }
}