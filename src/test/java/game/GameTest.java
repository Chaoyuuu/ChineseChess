package game;

import chess.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock
    private Point point;

    @Mock
    private List<Player> spyPlayer = spy(new ArrayList<>());

    @Mock
    private ChessBoard chessBoard;

    @InjectMocks
    private Game game;

    void givenRedGeneralDead() {
        Chess[] chessArray = {
                new Pawn(ChessColor.RED, point),
                new Pawn(ChessColor.BLACK, point),
                new General(ChessColor.BLACK, point),
                new General(ChessColor.RED, new Point(10, 10)),
                new Knight(ChessColor.RED, point),
                new Knight(ChessColor.BLACK, point)};
        chessBoard = new ChessBoard(chessArray);
        game = new Game(chessBoard);
    }

    @Test
    void WhenUndo_ThenCallChessBoardUndoChess() {
        game.undo();
        verify(chessBoard).undoChess();
    }

    @Test
    void GivenPoints_WhenMove_ThenCallChessBoardMove() {
        game.move(point, point);
        verify(chessBoard).moveChess(point, point);
    }

    @Test
    void GivenRedGeneralDead_WhenInvokeIsEndGame_ThenReturnTrue() {
        givenRedGeneralDead();
        assertTrue(game.endGame());
    }
}