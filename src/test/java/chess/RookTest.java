package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RookTest extends BaseTest{

    private Chess rook;
    private ChessBoard chessBoard;

    void givenTwoChess(int x1, int y1, int x2, int y2) {
        Chess[] chessArray = {
                new Rook(ChessColor.BLACK, new Point(x1, y1)),
                new Elephant(ChessColor.BLACK, new Point(x2, y2))};
        chessBoard = new ChessBoard(chessArray);
        rook = chessBoard.getChessList().get(0);
    }

    void givenRookAt(int x, int y) {
        Chess[] chessArray = {new Rook(ChessColor.BLACK, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        rook = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenRookAtX3Y3_WhenMoveToX3Y5_ThenShouldSucceed() {
        givenRookAt(3, 3);
        rook.move(3, 5);
        assertPointAt(3, 5, rook.getCurrentPoint());
    }

    @Test
    void GivenRookAtX3Y3_WhenMoveToX5Y3_ThenShouldSucceed() {
        givenRookAt(3, 3);
        rook.move(5, 3);
        assertPointAt(5, 3, rook.getCurrentPoint());
    }

    @Test
    void GivenRookAtX3Y3_WhenMoveToX1Y3_ThenShouldSucceed() {
        givenRookAt(3, 3);
        rook.move(1, 3);
        assertPointAt(1, 3, rook.getCurrentPoint());
    }

    @Test
    void GivenRookAtX3Y3_WhenMoveToX3Y0_ThenShouldSucceed() {
        givenRookAt(3, 3);
        rook.move(3, 0);
        assertPointAt(3, 0, rook.getCurrentPoint());
    }

    @Test
    void GivenRookIAtX3Y3_WhenMoveToX6Y7_ThenThrowsInvalidMoveException() {
        givenRookAt(3, 3);
        assertThrows(InvalidMoveException.class, () -> rook.move(6, 7));
    }

    @Test
    void GivenRookAtX3Y3_AndAChessIn63_WhenMoveToX8Y3_ThenThrowsInvalidMoveException() {
        givenTwoChess(3, 3, 6, 3);
        assertThrows(InvalidMoveException.class, () -> rook.move(8, 3));
    }

}