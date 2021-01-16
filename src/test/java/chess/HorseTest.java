package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HorseTest extends BaseTest {
    private Chess horse;
    private ChessBoard chessBoard;

    void giveHorseAt(int x, int y) {
        Chess[] chessArray = {
                new Horse(ChessColor.RED, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        horse = chessBoard.getChessList().get(0);
    }

    void giveTwoChessAt(int x1, int y1, int x2, int y2) {
        Chess[] chessArray = {
                new Horse(ChessColor.RED, new Point(x1, y1)),
                new Elephant(ChessColor.BLACK, new Point(x2, y2))};
        chessBoard = new ChessBoard(chessArray);
        horse = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX5Y6_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(5, 6);
        assertPointAt(5, 6, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX6Y5_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(6, 5);
        assertPointAt(6, 5, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX6Y3_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(6, 3);
        assertPointAt(6, 3, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX5Y2_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(5, 2);
        assertPointAt(5, 2, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX3Y2_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(3, 2);
        assertPointAt(3, 2, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX2Y3_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(2, 3);
        assertPointAt(2, 3, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX2Y5_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(2, 5);
        assertPointAt(2, 5, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX3Y6_ThenShouldSucceed() {
        giveHorseAt(4, 4);
        horse.move(3, 6);
        assertPointAt(3, 6, horse.getCurrentPoint());
    }

    @Test
    void GivenHorseAtX4Y4_WhenMoveToX7Y7_ThenThrowsInvalidMoveException() {
        giveHorseAt(4, 4);
        assertThrows(InvalidMoveException.class, () -> horse.move(7, 7));
    }

    @Test
    void GivenHorseAtX4Y4AndAChessAtX4Y5_WhenMoveToX5Y6_ThenThrowsInvalidMoveException() {
        giveTwoChessAt(4, 4, 4, 5);
        assertThrows(InvalidMoveException.class, () -> horse.move(1, 4));
    }

    @Test
    void GivenHorseAtX4Y4AndAChessAtX3Y4_WhenMoveToX2Y5_ThenThrowsInvalidMoveException() {
        giveTwoChessAt(4, 4, 3, 4);
        assertThrows(InvalidMoveException.class, () -> horse.move(2, 5));
    }

    @Test
    void GivenHorseAtX4Y4AndAChessAtX4Y3_WhenMoveToX3Y2_ThenThrowsInvalidMoveException() {
        giveTwoChessAt(4, 4, 4, 3);
        assertThrows(InvalidMoveException.class, () -> horse.move(3, 2));
    }

    @Test
    void GivenHorseAtX4Y4AndAChessAtX5Y4_WhenMoveToX6Y3_ThenThrowsInvalidMoveException() {
        giveTwoChessAt(4, 4, 5, 4);
        assertThrows(InvalidMoveException.class, () -> horse.move(6, 3));
    }
}