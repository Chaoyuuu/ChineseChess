package controller;

import exception.InvalidMoveException;
import game.ChessBoard;
import view.ChessListViewModel;
import view.Media;
import view.View;
import view.ViewObserver;

import java.awt.*;

import static view.ChessListViewModel.toViewModel;
import static view.Media.*;
import static view.Utils.mapPointFromViewToGame;

public class Presenter implements ViewObserver {

    public Observable<ChessListViewModel> chess$ = new Observable<>();
    public Observable<Media> audio$ = new Observable<>();
    private ChessBoard chessBoard;

    public Presenter(ChessBoard chessBoard, View view) {
        this.chessBoard = chessBoard;
        view.addObserver(this);
    }

    @Override
    public void onUndoChess() {
        chessBoard.undoChess();
        chess$.update(toViewModel(chessBoard.getChessList()));
    }

    @Override
    public void onMoveChess(Point selectPoint, Point nextPoint) {
        try {
            chessBoard.moveChess(mapPointFromViewToGame(selectPoint), mapPointFromViewToGame(nextPoint));
            chess$.update(toViewModel(chessBoard.getChessList()));
            audio$.update(PUT);
        } catch (InvalidMoveException | IllegalArgumentException e) {
            audio$.update(ERROR);
        }
    }
}
