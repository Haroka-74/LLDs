package states;

import models.Board;
import models.Player;

public abstract class State {
    protected Context context;
    protected Board board;
    protected Player current;
    protected Player next;

    public State(Board board, Player current, Player next) {
        this.board = board;
        this.current = current;
        this.next = next;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void execute();
}