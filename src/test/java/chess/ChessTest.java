package chess;

import game.ChessBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    private Chess chess;
    private ChessBoard chessBoard;

    @BeforeEach
    void setup(){
        Chess[] chessArray = {
                new Horse(ChessColor.BLACK, new Point(4, 4))
        };
        chessBoard = new ChessBoard(chessArray);
        chess = chessBoard.getChessList().get(0);
    }

    @Test
    void GivenChessAndUndoPoint_WhenUndo_ThenUpdateCurrentPoint(){
        Point undoPoint = new Point(2, 3);
        chess.undo(undoPoint);
        assertEquals(chess.getCurrentPoint(), undoPoint);
    }

    @Test
    void GivenChess_WhenRemove_ThenUpdateCurrentPointTo1010(){
        chess.remove();
        assertEquals(chess.getCurrentPoint(), new Point(10, 10));
    }
}