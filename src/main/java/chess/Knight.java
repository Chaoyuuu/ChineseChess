package chess;

import java.awt.*;

public class Knight extends BoxChess {
    public Knight(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        return moveDiagonally(nextPoint) && isInTheBox(nextPoint);
    }
}
