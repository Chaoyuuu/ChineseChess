package game;

import chess.ChessColor;
import chess.General;
import exception.InvalidMoveException;

import java.awt.*;

import static chess.Chess.REMOVE_POINT;

public class Game {

    private ChessBoard chessBoard;

    public Game(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public void undo() {
        chessBoard.undoChess();
    }

    public void move(Point selectPoint, Point nextPoint) {
        try {
            chessBoard.moveChess(selectPoint, nextPoint);
        } catch (InvalidMoveException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean endGame() {
        return chessBoard.getChessList()
                .stream()
                .filter(c -> (c.getColor().equals(ChessColor.BLACK) || c.getColor().equals(ChessColor.RED)) &&
                        c.getClass().equals(General.class))
                .anyMatch(c -> c.getCurrentPoint().equals(REMOVE_POINT));

    }
}
