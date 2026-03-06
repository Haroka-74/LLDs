package states;

import models.Board;
import models.Player;

public class TieState extends State {

    public TieState(Board board, Player current, Player next) {
        super(board, current, next);
    }

    @Override
    public void execute() {
        if(board.isFull()) {
            System.out.println(board);
            System.out.println();
            System.out.println("It's a tie! Well played by both!");
        } else {
            context.transitionTo(new PlayingState(board, next, current));
            context.execute();
        }
    }
}