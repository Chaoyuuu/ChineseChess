package chess;

import java.awt.*;

public abstract class StraightChess extends Chess {

    private Point nextPoint = new Point();
    private int chessCount = 0;
    private int deltaX;
    private int deltaY;

    public StraightChess(ChessColor chessColor, Point nextPoint) {
        super(chessColor, nextPoint);
    }

    protected boolean moveHorizontally(Point nextPoint) {
        setDelta(nextPoint);
        countChessHorizontally();
        return deltaY == 0;
    }

    protected boolean moveVertically(Point nextPoint) {
        setDelta(nextPoint);
        countChessVertically();
        return deltaX == 0;
    }

    private void countChessHorizontally() {
        int offset = setOffset(deltaX);
        this.chessCount = 0;

        for (int i = 1; i < Math.abs(deltaX); i++) {
            nextPoint.setLocation(currentPoint.x + i * offset, currentPoint.y);
            if (chessBoard.chessExist(nextPoint)) {
                this.chessCount++;
            }
        }
    }

    private void countChessVertically() {
        int offset = setOffset(deltaY);
        this.chessCount = 0;

        for (int i = 1; i < Math.abs(deltaY); i++) {
            nextPoint.move(currentPoint.x, currentPoint.y + i * offset);
            if (chessBoard.getChessByPoint(nextPoint).isPresent()) {
                this.chessCount++;
            }
        }
    }

    protected boolean noChessOnMovePath() {
        return chessCount == 0;
    }

    protected boolean onlyOneChessOnMovePath() {
        return chessCount == 1;
    }

    private void setDelta(Point nextPoint) {
        this.deltaX = nextPoint.x - currentPoint.x;
        this.deltaY = nextPoint.y - currentPoint.y;
    }

    private int setOffset(int delta) {
        if (delta < 0) {
            return -1;
        }
        return 1;
    }

    public abstract boolean validMove(Point nextPoint);
}
