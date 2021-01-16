package chess;

import exception.InvalidMoveException;
import game.ChessBoard;

import java.awt.*;

public class PutChessCommand implements ChessCommand {

    private Chess chess;
    private Point previousPoint;
    private Chess removeChess;
    private Point removeChessPoint;

    @Override
    public void execute(ChessBoard chessBoard, Point selectPoint, Point nextPoint) {
        Chess selectChess = chessBoard.getChessByPoint(selectPoint)
                .orElseThrow(() -> new IllegalArgumentException("No chess found at the point " + selectPoint));
        Chess nextChess = chessBoard.getChessByPoint(nextPoint).orElse(null);

        if (nextChess != null && nextChess.getColor() != selectChess.getColor()) {
            moveChess(selectChess, nextPoint);
            removeChess(nextChess);
        } else if (nextChess == null) {
            moveChess(selectChess, nextPoint);
        } else {
            throw new InvalidMoveException("Cannot eat same color chess");
        }
    }

    private void moveChess(Chess chess, Point point) {
        this.chess = chess;
        previousPoint = new Point(chess.getCurrentPoint().x, chess.getCurrentPoint().y);
        chess.move(point);
    }

    private void removeChess(Chess chess) {
        removeChessPoint = new Point(chess.getCurrentPoint().x, chess.getCurrentPoint().y);
        removeChess = chess;
        chess.remove();
    }

    @Override
    public void undo() {
        chess.undo(previousPoint);
        if (removeChess != null) {
            removeChess.undo(removeChessPoint);
        }
    }

    public Point getPreviousPoint() {
        return previousPoint;
    }

}
