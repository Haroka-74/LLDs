package states;

import models.Board;
import models.Player;
import utils.Console;
import models.Position;

public class PlayingState extends State {

    public PlayingState(Board board, Player current, Player next) {
        super(board, current, next);
    }

    @Override
    public void execute() {
        Console.clear();

        Position position = current.move(board);

        board.place(position, current.getSymbol());
        Console.clear();

        context.transitionTo(new WinState(board, current, next));
        context.execute();
    }
}