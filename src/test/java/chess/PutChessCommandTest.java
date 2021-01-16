package chess;

import exception.InvalidMoveException;
import game.ChessBoard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PutChessCommandTest {

    private final Point selectPoint = new Point(1, 1);
    private final Point nextPoint = new Point(2, 2);

    @Mock
    private Chess nextChess;

    @Mock
    private Chess selectChess;

    @Mock
    private ChessBoard chessBoard;

    private ChessCommand chessCommand;

    void givenEmptyNextPoint() {
        when(chessBoard.getChessByPoint(selectPoint)).thenReturn(Optional.of(selectChess));
        when(chessBoard.getChessByPoint(nextPoint)).thenReturn(Optional.empty());
        when(selectChess.getCurrentPoint()).thenReturn(selectPoint);
        when(nextChess.getCurrentPoint()).thenReturn(selectPoint);
        chessCommand = new PutChessCommand();
    }

    void givenPointColors(ChessColor selectColor, ChessColor nextColor) {
        when(chessBoard.getChessByPoint(selectPoint)).thenReturn(Optional.of(selectChess));
        when(chessBoard.getChessByPoint(nextPoint)).thenReturn(Optional.of(nextChess));
        when(selectChess.getColor()).thenReturn(selectColor);
        when(selectChess.getCurrentPoint()).thenReturn(selectPoint);
        when(nextChess.getCurrentPoint()).thenReturn(selectPoint);
        when(nextChess.getColor()).thenReturn(nextColor);
        chessCommand = new PutChessCommand();
    }

    @Test
    void GivenNextPointIsEmpty_WhenExecute_ThenInvokeChessMove() {
        givenEmptyNextPoint();
        chessCommand.execute(chessBoard, selectPoint, nextPoint);
        verify(selectChess).move(nextPoint);
    }

    @Test
    void GivenRedPointAndBlackNextPoint_WhenExecute_ThenInvokeChessMove() {
        givenPointColors(ChessColor.RED, ChessColor.BLACK);
        chessCommand.execute(chessBoard, selectPoint, nextPoint);
        verify(selectChess).move(nextPoint);
        verify(nextChess).remove();
    }

    @Test
    void GivenRedPointAndRedNextPoint_WhenExecute_ThenThrowsInvalidMoveException() {
        givenPointColors(ChessColor.RED, ChessColor.RED);
        assertThrows(InvalidMoveException.class, () -> chessCommand.execute(chessBoard, selectPoint, nextPoint));
    }

    void givenExecuteWithEmptyNextPoint() {
        givenEmptyNextPoint();
        when(selectChess.getCurrentPoint()).thenReturn(selectPoint);
        chessCommand.execute(chessBoard, selectPoint, nextPoint);
    }

    @Test
    void GivenExecuteWithEmptyNextPoint_WhenUndo_ThenInvokeChessUndoMethod() {
        givenExecuteWithEmptyNextPoint();
        chessCommand.undo();
        verify(selectChess).undo(selectPoint);
        verify(nextChess, never()).undo(nextPoint);
    }

    void givenExecuteWithNextPoint() {
        givenPointColors(ChessColor.RED, ChessColor.BLACK);
        when(selectChess.getCurrentPoint()).thenReturn(selectPoint);
        when(nextChess.getCurrentPoint()).thenReturn(nextPoint);
        chessCommand.execute(chessBoard, selectPoint, nextPoint);
    }

    @Test
    void GivenExecuteWithNextPoint_WhenUndo_ThenInvokeChessUndoMethod() {
        givenExecuteWithNextPoint();
        chessCommand.undo();
        verify(selectChess).undo(selectPoint);
        verify(nextChess).undo(nextPoint);
    }

}