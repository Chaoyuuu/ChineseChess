package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CannonTest extends BaseTest {
    private Chess cannon;
    private ChessBoard chessBoard;

    void givenCannonAt(int x, int y) {
        Chess[] chessArray = {new Cannon(ChessColor.RED, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        cannon = chessBoard.getChessList().get(0);
    }

    void givenMultipleChess(Chess ...chessArray) {
        chessBoard = new ChessBoard(chessArray);
        cannon = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenCannonAtX4Y4_WhenMoveToX4Y5_ThenShouldSucceed() {
        givenCannonAt(4, 4);
        cannon.move(4, 5);
        assertPointAt(4, 5, cannon.getCurrentPoint());
    }

    @Test
    void GivenCannonAtX4Y4_WhenMoveToX7Y4_ThenShouldSucceed() {
        givenCannonAt(4, 4);
        cannon.move(7, 4);
        assertPointAt(7, 4, cannon.getCurrentPoint());
    }

    @Test
    void GivenCannonAtX4Y4_WhenMoveToX0Y4_ThenShouldSucceed() {
        givenCannonAt(4, 4);
        cannon.move(0, 4);
        assertPointAt(0, 4, cannon.getCurrentPoint());
    }

    @Test
    void GivenCannonAtX4Y4_WhenMoveToX4Y2_ThenShouldSucceed() {
        givenCannonAt(4, 4);
        cannon.move(4, 2);
        assertPointAt(4, 2, cannon.getCurrentPoint());
    }

    @Test
    void GivenCannonAtX4Y4AndAChessAtX4Y6_WhenMoveToX4Y7_ThenShouldSucceed() {
        givenMultipleChess(
                new Cannon(ChessColor.RED, new Point(4, 4)),
                new Elephant(ChessColor.BLACK, new Point(4, 6)),
                new Elephant(ChessColor.BLACK, new Point(4, 7)));
        cannon.move(4, 7);
        assertPointAt(4, 7, cannon.getCurrentPoint());
    }

    @Test
    void GivenCannonAtX4Y4AndTwoChessAtX4Y6AndAtX4Y7_WhenMoveToX4X8_ThenThrowsInvalidMoveException() {
        givenMultipleChess(
                new Cannon(ChessColor.RED, new Point(4, 4)),
                new Elephant(ChessColor.BLACK, new Point(4, 6)),
                new Elephant(ChessColor.BLACK, new Point(4, 7)),
                new Elephant(ChessColor.BLACK, new Point(4, 8)));
        assertThrows(InvalidMoveException.class, () -> cannon.move(4, 8));
    }

    @Test
    void GivenCannonAtX4Y4_WhenMoveToX6Y3_ThenThrowsInvalidMoveException() {
        givenCannonAt(4, 4);
        assertThrows(InvalidMoveException.class, () -> cannon.move(6, 3));
    }

    @Test
    void GivenCannonAtX4Y4AndAChessAtX4Y1_WhenMoveToX4Y0_ThenThrowsInvalidMoveException() {
        givenMultipleChess(
                new Cannon(ChessColor.RED, new Point(4, 4)),
                new Elephant(ChessColor.BLACK, new Point(4, 1)));
        assertThrows(InvalidMoveException.class, () -> cannon.move(4, 0));
    }
}