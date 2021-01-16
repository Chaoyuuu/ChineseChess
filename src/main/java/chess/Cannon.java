package chess;

import java.awt.*;

public class Cannon extends StraightChess {
    public Cannon(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        if (chessBoard.chessExist(nextPoint)) {
            return eatChess(nextPoint);
        } else {
            return moveChess(nextPoint);
        }
    }

    private boolean eatChess(Point nextPoint) {
        return (moveVertically(nextPoint) || moveHorizontally(nextPoint)) && onlyOneChessOnMovePath();
    }

    private boolean moveChess(Point nextPoint) {
        return (moveVertically(nextPoint) || moveHorizontally(nextPoint)) && noChessOnMovePath();
    }
}

