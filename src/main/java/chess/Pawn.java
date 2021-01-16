package chess;

import java.awt.*;

public class Pawn extends Chess {
    private Point verticalPoint = new Point();
    private Point rightPoint = new Point();
    private Point leftPoint = new Point();

    public Pawn(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        setMovePoint(chessColor);
        if (isCrossRiver(currentPoint.y, chessColor)) {
            return moveForwardAndHorizontally(nextPoint);
        } else {
            return moveForward(nextPoint);
        }
    }

    private void setMovePoint(ChessColor chessColor) {
        int offset = setOffset(chessColor);
        verticalPoint.setLocation(currentPoint.x, currentPoint.y + offset);
        rightPoint.setLocation(currentPoint.x + 1, currentPoint.y);
        leftPoint.setLocation(currentPoint.x - 1, currentPoint.y);
    }

    private int setOffset(ChessColor chessColor) {
        if (chessColor.equals(ChessColor.RED)) {
            return 1;
        } else {
            return -1;
        }
    }

    private boolean isCrossRiver(int y, ChessColor chessColor) {
        return (chessColor.equals(ChessColor.RED) && y >= 5) || (chessColor.equals(ChessColor.BLACK) && y <= 4);
    }

    private boolean moveForwardAndHorizontally(Point nextPoint) {
        return nextPoint.equals(verticalPoint) || nextPoint.equals(rightPoint) || nextPoint.equals(leftPoint);
    }

    private boolean moveForward(Point nextPoint) {
        return nextPoint.equals(verticalPoint);
    }
}
