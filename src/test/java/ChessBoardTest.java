import chess.*;
import game.ChessBoard;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChessBoardTest {
    private ChessBoard chessBoard;
    private Point selectPoint = new Point();
    private Point nextPoint = new Point();
    private ChessCommand chessCommand;
    private Chess chess;

    void setupOnlyOneChess(Chess chess) {
        Chess[] chessArray = {chess};
        chessBoard = new ChessBoard(chessArray);
        this.chess = chessBoard.getChessList().get(0);
    }

    void setupMultipleChess(Chess[] chessArray) {
        chessBoard = new ChessBoard(chessArray);
    }

    public void setSelectPoint(int x, int y) {
        this.selectPoint.setLocation(x, y);
    }

    public void setNextPoint(int x, int y) {
        this.nextPoint.setLocation(x, y);
    }

    @Test
    void GivenAChessAtX2Y6_WhenMoveChessToX2Y5_ThenThenShouldSucceed() {
        setSelectPoint(2, 6);
        setNextPoint(2, 5);
        setupOnlyOneChess(new Pawn(ChessColor.BLACK, selectPoint));

        chessBoard.moveChess(selectPoint, nextPoint);
        assertEquals(chess.getCurrentPoint(), nextPoint);
        assertEquals(chessBoard.getChessList().size(), 1);
    }

    @Test
    void GivenChessCommands_WhenUndoChess_ThenPopTheCommands() {
        chessCommand = setupChessCommandsByGivenPreviousPoint(new Point(9, 1));
        chessBoard.undoChess();
        verify(chessCommand, times(1)).undo();
    }

    PutChessCommand setupChessCommandsByGivenPreviousPoint(Point previousPoint) {
        setupMultipleChess(new Chess[0]);
        Stack<ChessCommand> chessCommands = new Stack<>();
        Stack<ChessCommand> spy = spy(chessCommands);

        PutChessCommand putChessCommand = mock(PutChessCommand.class);
        doReturn(putChessCommand).when(spy).pop();
        when(putChessCommand.getPreviousPoint()).thenReturn(previousPoint);

        chessBoard.setChessCommands(spy);
        return putChessCommand;
    }

}
