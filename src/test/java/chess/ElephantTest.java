package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ElephantTest extends BaseTest {

    private Chess elephant;
    private ChessBoard chessBoard;

    void givenElephantAt(int x, int y) {
        Chess[] chessArray = {new Elephant(ChessColor.RED, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        elephant = chessBoard.getChessList().get(0);
    }

    void givenMultipleChess(Chess... chessArray) {
        chessBoard = new ChessBoard(chessArray);
        elephant = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenElephantAtX4Y4_WhenMoveToX6Y6_ThenShouldSucceed() {
        givenElephantAt(4, 4);
        elephant.move(6, 6);
        assertPointAt(6, 6, elephant.getCurrentPoint());
    }

    @Test
    void GivenElephantAtX4Y4_WhenMoveToX2Y6_ThenShouldSucceed() {
        givenElephantAt(4, 4);
        elephant.move(2, 6);
        assertPointAt(2, 6, elephant.getCurrentPoint());
    }

    @Test
    void GivenElephantAtX4Y4_WhenMoveToX2Y2_ThenShouldSucceed() {
        givenElephantAt(4, 4);
        elephant.move(2, 2);
        assertPointAt(2, 2, elephant.getCurrentPoint());
    }

    @Test
    void GivenElephantAtX4Y4_WhenMoveToX6Y2_ThenShouldSucceed() {
        givenElephantAt(4, 4);
        elephant.move(6, 2);
        assertPointAt(6, 2, elephant.getCurrentPoint());
    }

    @Test
    void GivenElephantIn44_WhenMoveToX4Y5_ThenThrowsInvalidMoveException() {
        givenElephantAt(4, 4);
        assertThrows(InvalidMoveException.class, () -> elephant.move(4, 5));
    }

    @Test
    void GivenElephantIn44AndAChessAtX5Y5_WhenMoveToX6Y6_ThenThrowsInvalidMoveException() {
        givenMultipleChess(
                new Elephant(ChessColor.RED, new Point(4, 4)),
                new Pawn(ChessColor.BLACK, new Point(5, 5)));
        assertThrows(InvalidMoveException.class, () -> elephant.move(6, 6));
    }

    @Test
    void GivenElephantIn44AndAChessAtX3Y5_WhenMoveToX2Y6_ThenThrowsInvalidMoveException() {
        givenMultipleChess(
                new Elephant(ChessColor.RED, new Point(4, 4)),
                new Pawn(ChessColor.BLACK, new Point(3, 5)));
        assertThrows(InvalidMoveException.class, () -> elephant.move(2, 6));
    }

    @Test
    void GivenElephantIn44AndAChessAtX3Y3_WhenMoveToX2Y2_ThenThrowsInvalidMoveException() {
        givenMultipleChess(
                new Elephant(ChessColor.RED, new Point(4, 4)),
                new Pawn(ChessColor.BLACK, new Point(3, 3)));
        assertThrows(InvalidMoveException.class, () -> elephant.move(2, 2));
    }

    @Test
    void GivenElephantIn44AndAChessAtX5Y3_WhenMoveToX6Y2_ThenThrowsInvalidMoveException() {
        givenMultipleChess(
                new Elephant(ChessColor.RED, new Point(4, 4)),
                new Pawn(ChessColor.BLACK, new Point(5, 3)));
        assertThrows(InvalidMoveException.class, () -> elephant.move(6, 2));
    }
}