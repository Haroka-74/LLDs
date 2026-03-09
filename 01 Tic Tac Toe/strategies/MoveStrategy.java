package strategies;

import models.Board;
import models.Position;

public interface MoveStrategy {
    Position move(Board board, String name);
}