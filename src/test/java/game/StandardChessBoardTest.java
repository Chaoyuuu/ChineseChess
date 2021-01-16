package game;

import chess.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StandardChessBoardTest {

    private ChessBoard chessBoard;

    @BeforeEach
    void setup(){
        chessBoard = new StandardChessBoard();
    }

    @Test
    void GivenNewChessBoard_WhenGetChessListSize_ThenGet32() {
        assertEquals(32, chessBoard.getChessList().size());
    }

    @Test
    void GivenInitChess_ThenAllChessPositionsAreCorrect() {
        List<Chess> chessList = chessBoard.getChessList();
        assertPoint(0, 0, Rook.class, ChessColor.RED, chessList);
        assertPoint(1, 0, Horse.class, ChessColor.RED, chessList);
        assertPoint(2, 0, Elephant.class, ChessColor.RED, chessList);
        assertPoint(3, 0, Knight.class, ChessColor.RED, chessList);
        assertPoint(4, 0, General.class, ChessColor.RED, chessList);
        assertPoint(5, 0, Knight.class, ChessColor.RED, chessList);
        assertPoint(6, 0, Elephant.class, ChessColor.RED, chessList);
        assertPoint(7, 0, Horse.class, ChessColor.RED, chessList);
        assertPoint(8, 0, Rook.class, ChessColor.RED, chessList);
        assertPoint(1, 2, Cannon.class, ChessColor.RED, chessList);
        assertPoint(7, 2, Cannon.class, ChessColor.RED, chessList);
        assertPoint(0, 3, Pawn.class, ChessColor.RED, chessList);
        assertPoint(2, 3, Pawn.class, ChessColor.RED, chessList);
        assertPoint(4, 3, Pawn.class, ChessColor.RED, chessList);
        assertPoint(6, 3, Pawn.class, ChessColor.RED, chessList);
        assertPoint(8, 3, Pawn.class, ChessColor.RED, chessList);

        assertPoint(0, 9, Rook.class, ChessColor.BLACK, chessList);
        assertPoint(1, 9, Horse.class, ChessColor.BLACK, chessList);
        assertPoint(2, 9, Elephant.class, ChessColor.BLACK, chessList);
        assertPoint(3, 9, Knight.class, ChessColor.BLACK, chessList);
        assertPoint(4, 9, General.class, ChessColor.BLACK, chessList);
        assertPoint(5, 9, Knight.class, ChessColor.BLACK, chessList);
        assertPoint(6, 9, Elephant.class, ChessColor.BLACK, chessList);
        assertPoint(7, 9, Horse.class, ChessColor.BLACK, chessList);
        assertPoint(8, 9, Rook.class, ChessColor.BLACK, chessList);
        assertPoint(1, 7, Cannon.class, ChessColor.BLACK, chessList);
        assertPoint(7, 7, Cannon.class, ChessColor.BLACK, chessList);
        assertPoint(0, 6, Pawn.class, ChessColor.BLACK, chessList);
        assertPoint(2, 6, Pawn.class, ChessColor.BLACK, chessList);
        assertPoint(4, 6, Pawn.class, ChessColor.BLACK, chessList);
        assertPoint(6, 6, Pawn.class, ChessColor.BLACK, chessList);
        assertPoint(8, 6, Pawn.class, ChessColor.BLACK, chessList);
    }

    void assertPoint(int x, int y, Class<?> clazz, ChessColor chessColor, List<Chess> chessList) {
        Point point = new Point(x, y);
        assertTrue(chessList.stream()
                .anyMatch(c -> c.getClass().equals(clazz) &&
                        c.getColor().equals(chessColor) &&
                        c.getCurrentPoint().equals(point)));
    }
}