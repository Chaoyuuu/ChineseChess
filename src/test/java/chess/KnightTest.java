package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class KnightTest extends BaseTest{
    private Chess knight;
    private ChessBoard chessBoard;

    private final Point CENTRAL_POINT = new Point(4, 1);
    private final Point RIGHT_UP_POINT = new Point(5, 2);
    private final Point RIGHT_DOWN_POINT = new Point(5, 0);
    private final Point LEFT_UP_POINT = new Point(3, 2);
    private final Point LEFT_DOWN_POINT = new Point(3, 0);

    void givenKnightAt(Point initPoint) {
        Chess[] chessArray = {new Knight(ChessColor.RED, initPoint)};
        chessBoard = new ChessBoard(chessArray);
        knight = chessBoard.getChessList().get(0);
    }

    void givenKnightAt(int x, int y) {
        Chess[] chessArray = {new Knight(ChessColor.RED, new Point(x, y))};
        chessBoard = new ChessBoard(chessArray);
        knight = chessBoard.getChessList().get(0);
    }

    @ParameterizedTest
    @MethodSource
    void GivenKnightInCentralAndNextPointInFourDirection_WhenMove_ThenUpdateCurrentPoint(Point nextPoint) {
        givenKnightAt(CENTRAL_POINT);
        knight.move(nextPoint);
        assertPointAt(nextPoint, knight.getCurrentPoint());
    }

    static Stream<Point> GivenKnightInCentralAndNextPointInFourDirection_WhenMove_ThenUpdateCurrentPoint() {
        return Stream.of(new Point(5, 2), new Point(5, 0), new Point(3, 2), new Point(3, 0));
    }

    @Test
    void GivenKnightAtX4Y8_WhenMoveToX5Y9_ThenShouldSucceed() {
        givenKnightAt(4, 8);
        knight.move(5, 9);
        assertPointAt(5, 9, knight.getCurrentPoint());
    }

    @Test
    void GivenKnightAtLeftUp_WhenMoveToCentral_ThenShouldSucceed() {
        givenKnightAt(LEFT_UP_POINT);
        knight.move(CENTRAL_POINT);
        assertPointAt(CENTRAL_POINT, knight.getCurrentPoint());
    }

    @Test
    void GivenKnightAtLeftDown_WhenMoveToCentral_ThenShouldSucceed() {
        givenKnightAt(LEFT_DOWN_POINT);
        knight.move(CENTRAL_POINT);
        assertPointAt(CENTRAL_POINT, knight.getCurrentPoint());
    }

    @Test
    void GivenKnightAtRightUp_WhenMoveToCentral_ThenShouldSucceed() {
        givenKnightAt(RIGHT_UP_POINT);
        knight.move(CENTRAL_POINT);
        assertPointAt(CENTRAL_POINT, knight.getCurrentPoint());
    }

    @Test
    void GivenKnightInRightDown_WhenMoveToCentral_ThenShouldSucceed() {
        givenKnightAt(RIGHT_DOWN_POINT);
        knight.move(CENTRAL_POINT);
        assertPointAt(CENTRAL_POINT, knight.getCurrentPoint());
    }

    @Test
    void GivenKnightInLeftUp_WhenMoveToX3Y1_ThenThrowsInvalidMoveException() {
        givenKnightAt(LEFT_UP_POINT);
        assertThrows(InvalidMoveException.class, () -> knight.move(3, 1));
    }

    @Test
    void GivenKnightInLeftUp_WhenMoveToRightDown_ThenThrowsInvalidMoveException() {
        givenKnightAt(LEFT_UP_POINT);
        assertThrows(InvalidMoveException.class, () -> knight.move(RIGHT_DOWN_POINT));
    }

}