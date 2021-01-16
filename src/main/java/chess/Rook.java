package chess;

import java.awt.*;


public class Rook extends StraightChess {

    public Rook(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        return (moveVertically(nextPoint) || moveHorizontally(nextPoint)) && noChessOnMovePath();
    }
}
