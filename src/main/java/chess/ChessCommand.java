package chess;

import game.ChessBoard;

import java.awt.*;

public interface ChessCommand {
    void execute(ChessBoard chessBoard, Point selectPoint, Point nextPoint);

    void undo();
}
