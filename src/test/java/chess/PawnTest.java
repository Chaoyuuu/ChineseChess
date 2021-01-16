package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PawnTest extends BaseTest{

    private Chess pawn;
    private ChessBoard chessBoard;

    void givenPawnPointAndColor(int x, int y, ChessColor color) {
        Chess[] chessArray = {new Pawn(color, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        pawn = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenRedPawnAtX2Y3_WhenMoveToX2Y4_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 3, ChessColor.RED);
        pawn.move(2, 4);
        assertPointAt(2, 4, pawn.getCurrentPoint());
    }

    @Test
    void GivenRedPawnAtX2Y3_WhenMoveToX3Y3_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 3, ChessColor.RED);
        assertThrows(InvalidMoveException.class, () -> pawn.move(3, 3));
    }

    @Test
    void GivenRedPawnAtX2Y3_WhenMoveToX1Y3_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 3, ChessColor.RED);
        assertThrows(InvalidMoveException.class, () -> pawn.move(1, 3));
    }

    @Test
    void GivenRedPawnAtX2Y3_WhenMoveToX2Y2_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 3, ChessColor.RED);
        assertThrows(InvalidMoveException.class, () -> pawn.move(2, 2));
    }


    @Test
    void GivenRedPawnAtX2Y6_WhenMoveToX2Y7_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 6, ChessColor.RED);
        pawn.move(2, 7);
        assertPointAt(2, 7, pawn.getCurrentPoint());
    }

    @Test
    void GivenRedPawnAtX2Y6_WhenMoveToX3Y6_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 6, ChessColor.RED);
        pawn.move(3, 6);
        assertPointAt(3, 6, pawn.getCurrentPoint());
    }

    @Test
    void GivenRedPawnAtX2Y6_WhenMoveToX1Y6_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 6, ChessColor.RED);
        pawn.move(1, 6);
        assertPointAt(1, 6, pawn.getCurrentPoint());
    }

    @Test
    void GivenRedPawnAtX2Y6_WhenMoveToX2Y5_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 6, ChessColor.RED);
        assertThrows(InvalidMoveException.class, () -> pawn.move(2, 5));
    }

    @Test
    void GivenBlackPawnAtX2Y6_WhenMoveToX2Y5_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 6, ChessColor.BLACK);
        pawn.move(2, 5);
        assertPointAt(2, 5, pawn.getCurrentPoint());
    }

    @Test
    void GivenBlackPawnAtX2Y6_WhenMoveToX1Y6_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 6, ChessColor.BLACK);
        assertThrows(InvalidMoveException.class, () -> pawn.move(1, 6));
    }

    @Test
    void GivenBlackPawnAtX2Y6_WhenMoveToX3Y6_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 6, ChessColor.BLACK);
        assertThrows(InvalidMoveException.class, () -> pawn.move(3, 6));
    }

    @Test
    void GivenBlackPawnAtX2Y6_WhenMoveToX2Y7_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 6, ChessColor.BLACK);
        assertThrows(InvalidMoveException.class, () -> pawn.move(2, 7));
    }

    @Test
    void GivenBlackPawnAtX2Y3_WhenMoveToX2Y2_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 3, ChessColor.BLACK);
        pawn.move(2,2);
        assertPointAt(2,2, pawn.getCurrentPoint());
    }

    @Test
    void GivenBlackPawnAtX2Y3_WhenMoveToX1Y3_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 3, ChessColor.BLACK);
        pawn.move(1, 3);
        assertPointAt(1, 3, pawn.getCurrentPoint());
    }

    @Test
    void GivenBlackPawnAtX2Y3_WhenMoveToX3Y3_ThenShouldSucceed() {
        givenPawnPointAndColor(2, 3, ChessColor.BLACK);
        pawn.move(3, 3);
        assertPointAt(3, 3, pawn.getCurrentPoint());
    }

    @Test
    void GivenBlackPawnAtX2Y3_WhenMoveToX2Y4_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 3, ChessColor.BLACK);
        assertThrows(InvalidMoveException.class, () -> pawn.move(2, 4));
    }

    @Test
    void GivenBlackPawnAtX2Y7_WhenMoveToX2Y5_ThenThrowsInvalidMoveException() {
        givenPawnPointAndColor(2, 7, ChessColor.BLACK);
        assertThrows(InvalidMoveException.class, () -> pawn.move(2, 5));
    }

}