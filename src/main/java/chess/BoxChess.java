package chess;

import java.awt.*;

public abstract class BoxChess extends Chess {
    public BoxChess(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    public boolean moveDiagonally(Point nextPoint) {
        int moveX = nextPoint.x - currentPoint.x;
        int moveY = nextPoint.y - currentPoint.y;
        return Math.abs(moveX) == 1 && Math.abs(moveY) == 1;
    }

    public boolean moveStraight(Point nextPoint) {
        int moveX = nextPoint.x - currentPoint.x;
        int moveY = nextPoint.y - currentPoint.y;

        return (Math.abs(moveX) == 1 && Math.abs(moveY) == 0) ||
                (Math.abs(moveX) == 0 && Math.abs(moveY) == 1);
    }

    public boolean isInTheBox(Point nextPoint) {
        int x = nextPoint.x;
        int y = nextPoint.y;
        if (y >= 4) {
            return x >= 3 && x <= 5 && y >= 7 && y <= 9;
        } else {
            return x >= 3 && x <= 5 && y >= 0 && y <= 2;
        }
    }

    public abstract boolean validMove(Point nextPoint);
}
