package game;

import chess.*;

import java.awt.*;

import static chess.ChessColor.BLACK;
import static chess.ChessColor.RED;

public class StandardChessBoard extends ChessBoard {

    private static Chess[] initChess() {
        Chess[] chessArray = new Chess[32];
        spawnRedChess(chessArray);
        spawnBlackChess(chessArray);
        return chessArray;
    }

    public StandardChessBoard() {
        super(initChess());
    }

    private static void spawnRedChess(Chess[] chessList) {
        chessList[0] = new Rook(RED, new Point(0, 0));
        chessList[1] = new Horse(RED, new Point(1, 0));
        chessList[2] = new Elephant(RED, new Point(2, 0));
        chessList[3] = new Knight(RED, new Point(3, 0));
        chessList[4] = new General(RED, new Point(4, 0));
        chessList[5] = new Knight(RED, new Point(5, 0));
        chessList[6] = new Elephant(RED, new Point(6, 0));
        chessList[7] = new Horse(RED, new Point(7, 0));
        chessList[8] = new Rook(RED, new Point(8, 0));
        chessList[9] = new Cannon(RED, new Point(1, 2));
        chessList[10] = new Cannon(RED, new Point(7, 2));
        chessList[11] = new Pawn(RED, new Point(0, 3));
        chessList[12] = new Pawn(RED, new Point(2, 3));
        chessList[13] = new Pawn(RED, new Point(4, 3));
        chessList[14] = new Pawn(RED, new Point(6, 3));
        chessList[15] = new Pawn(RED, new Point(8, 3));
    }

    private static void spawnBlackChess(Chess[] chessList) {
        chessList[16] = new Rook(BLACK, new Point(0, 9));
        chessList[17] = new Horse(BLACK, new Point(1, 9));
        chessList[18] = new Elephant(BLACK, new Point(2, 9));
        chessList[19] = new Knight(BLACK, new Point(3, 9));
        chessList[20] = new General(BLACK, new Point(4, 9));
        chessList[21] = new Knight(BLACK, new Point(5, 9));
        chessList[22] = new Elephant(BLACK, new Point(6, 9));
        chessList[23] = new Horse(BLACK, new Point(7, 9));
        chessList[24] = new Rook(BLACK, new Point(8, 9));
        chessList[25] = new Cannon(BLACK, new Point(1, 7));
        chessList[26] = new Cannon(BLACK, new Point(7, 7));
        chessList[27] = new Pawn(BLACK, new Point(0, 6));
        chessList[28] = new Pawn(BLACK, new Point(2, 6));
        chessList[29] = new Pawn(BLACK, new Point(4, 6));
        chessList[30] = new Pawn(BLACK, new Point(6, 6));
        chessList[31] = new Pawn(BLACK, new Point(8, 6));
    }

}
