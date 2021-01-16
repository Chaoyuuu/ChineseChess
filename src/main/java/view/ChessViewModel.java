package view;

import chess.Chess;
import chess.ChessColor;

import java.awt.*;

import static view.Utils.mapPointFromGameToView;

public class ChessViewModel {
    public Point point;
    public ChessColor color;
    public String chessName;
    public int x;
    public int y;

    public ChessViewModel(Point point, ChessColor chessColor, String type) {
        this.point = mapPointFromGameToView(point);
        this.color = chessColor;
        this.x = this.point.x;
        this.y = this.point.y;
        this.chessName = getChessName(chessColor, type);
    }

    private String getChessName(ChessColor color, String type) {
        return color.name().toLowerCase() + "." + type;
    }

    public static ChessViewModel toViewModel(Chess chess) {
        return new ChessViewModel(chess.getCurrentPoint(), chess.getColor(), chess.getClass().getName());
    }
}
