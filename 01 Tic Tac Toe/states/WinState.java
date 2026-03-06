package states;

import models.Board;
import models.Player;

public class WinState extends State {

    public WinState(Board board, Player current, Player next) {
        super(board, current, next);
    }

    @Override
    public void execute() {
        if(board.hasWinner()) {
            System.out.println(board);
            System.out.println();
            System.out.println(current.getName() + " wins the game!");
        } else {
            context.transitionTo(new TieState(board, current, next));
            context.execute();
        }
    }
}