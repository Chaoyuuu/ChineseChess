package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GeneralTest extends BaseTest {

    private Chess general;
    private ChessBoard chessBoard;

    void givenGeneralAt(int x, int y) {
        Chess[] chessArray = {new General(ChessColor.RED, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        general = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX3Y2_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 1);
        assertThrows(InvalidMoveException.class, () -> general.move(3, 2));
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX4Y2_ThenShouldSucceed() {
        givenGeneralAt(4, 1);
        general.move(4, 2);
        assertPointAt(4, 2, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX4Y2_WhenMoveToX4Y1_ThenShouldSucceed() {
        givenGeneralAt(4, 2);
        general.move(4, 1);
        assertPointAt(4, 1, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX5Y2_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 1);
        assertThrows(InvalidMoveException.class, () -> general.move(5, 2));
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX3Y1_ThenShouldSucceed() {
        givenGeneralAt(4, 1);
        general.move(3, 1);
        assertPointAt(3, 1, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX5Y1_ThenShouldSucceed() {
        givenGeneralAt(4, 1);
        general.move(5, 1);
        assertPointAt(5, 1, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX3Y0_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 1);
        assertThrows(InvalidMoveException.class, () -> general.move(3, 0));
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX4Y0_ThenShouldSucceed() {
        givenGeneralAt(4, 1);
        general.move(4, 0);
        assertPointAt(4, 0, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX4Y1_WhenMoveToX5Y0_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 1);
        assertThrows(InvalidMoveException.class, () -> general.move(5,0));
    }


    @Test
    void GivenGeneralAtX3Y2_WhenMoveToX4Y2_ThenShouldSucceed() {
        givenGeneralAt(3, 2);
        general.move(4, 2);
        assertPointAt(4, 2, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX3Y2_WhenMoveToX3Y1_ThenShouldSucceed() {
        givenGeneralAt(3, 2);
        general.move(3, 1);
        assertPointAt(3, 1, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX3Y2_WhenMoveToX5Y0_ThenThrowsInvalidMoveException() {
        givenGeneralAt(3, 2);
        assertThrows(InvalidMoveException.class, () -> general.move(5, 0));
    }

    @Test
    void GivenGeneralAtX3Y2_WhenMoveToX3Y3_ThenThrowsInvalidMoveException() {
        givenGeneralAt(3, 2);
        assertThrows(InvalidMoveException.class, () -> general.move(3, 3));
    }

    @Test
    void GivenGeneralAtX4Y0_WhenMoveToX3Y1_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 0);
        assertThrows(InvalidMoveException.class, () -> general.move(3, 1));
    }

    @Test
    void GivenGeneralAtX4Y0_WhenMoveToX5Y1_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 0);
        assertThrows(InvalidMoveException.class, () -> general.move(5, 1));
    }

    // Blackchess
    @Test
    void GivenGeneralAtX4Y9_WhenMoveToX4Y8_ThenShouldSucceed() {
        givenGeneralAt(4, 9);
        general.move(4, 8);
        assertPointAt(4, 8, general.getCurrentPoint());
    }

    @Test
    void GivenGeneralAtX4Y9_WhenMoveToX5Y7_ThenThrowsInvalidMoveException() {
        givenGeneralAt(4, 9);
        assertThrows(InvalidMoveException.class, () -> general.move(5, 7));

    }

}