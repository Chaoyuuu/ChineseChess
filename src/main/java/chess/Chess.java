package chess;

import exception.InvalidMoveException;
import game.ChessBoard;

import java.awt.*;

public abstract class Chess {

    protected ChessBoard chessBoard;
    protected ChessColor chessColor;
    protected Point currentPoint;
    public static final Point REMOVE_POINT = new Point(10, 10);

    public Chess(ChessColor chessColor, Point point) {
        this.chessColor = chessColor;
        this.currentPoint = point;
    }

    public void move(int x, int y) {
        move(new Point(x, y));
    }

    public void move(Point nextPoint) {
        if (validMove(nextPoint)) {
            this.currentPoint.setLocation(nextPoint);
        } else {
            throw new InvalidMoveException("Invalid move in Chess");
        }
    }

    public abstract boolean validMove(Point nextPoint);

    public void undo(Point undoPoint) {
        currentPoint.setLocation(undoPoint);
    }

    public void remove() {
        currentPoint.setLocation(REMOVE_POINT);
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public ChessColor getColor() {
        return chessColor;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }
}


