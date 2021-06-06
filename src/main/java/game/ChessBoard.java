package game;

import chess.Chess;
import chess.ChessCommand;
import chess.PutChessCommand;

import java.awt.*;
import java.util.List;
import java.util.*;

public class ChessBoard {

    private Stack<ChessCommand> chessCommands = new Stack<>();
    private List<Chess> chessList;

    public ChessBoard(Chess... chessList) {
        this.chessList = Arrays.asList(chessList);
        Arrays.stream(chessList).forEach(c -> c.setChessBoard(this));
    }

    public void moveChess(Point selectPoint, Point nextPoint) {
        ChessCommand chessCommand = new PutChessCommand();
        chessCommand.execute(this, selectPoint, nextPoint);
        chessCommands.add(chessCommand);
    }

    public void undoChess() {
        try {
            ChessCommand chessCommand = chessCommands.pop();
            chessCommand.undo();
        } catch (EmptyStackException e) {
        }
    }

    public Optional<Chess> getChessByPoint(int x, int y) {
        return getChessByPoint(new Point(x, y));
    }

    public Optional<Chess> getChessByPoint(Point point) {
        if (isInTheBoundary(point)) {
            for (Chess chess : chessList) {
                if (chess.getCurrentPoint().equals(point)) {
                    return Optional.of(chess);
                }
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    public List<Chess> getChessByCol(int x) {
        List<Chess> chessList = new ArrayList<>();
        for (int i=0; i<=9; i++) {
            getChessByPoint(x, i).ifPresent(chessList::add);
        }
        return chessList;
    }

    public boolean chessExist(int x, int y) {
        return chessExist(new Point(x, y));
    }

    public boolean chessExist(Point point) {
        for (Chess chess : chessList) {
            if (chess.getCurrentPoint().equals(point)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInTheBoundary(Point point) {
        return point.x < 9 && point.x >= 0 && point.y < 10 && point.y >= 0;
    }

    public List<Chess> getChessList() {
        return this.chessList;
    }

    public Stack<ChessCommand> getChessCommands() {
        return chessCommands;
    }

    public void setChessCommands(Stack<ChessCommand> chessCommands) {
        this.chessCommands = chessCommands;
    }
}
