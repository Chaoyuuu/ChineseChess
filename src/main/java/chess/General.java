package chess;

import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class General extends BoxChess {

    public General(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        return normalMove(nextPoint) || specialMove(nextPoint);
    }

    private boolean normalMove(Point nextPoint) {
        return moveStraight(nextPoint) && isInTheBox(nextPoint);
    }

    private boolean specialMove(Point nextPoint) {
        return onlyTwoGeneralChessInSameCol(currentPoint, nextPoint) &&
                chessBoard.getChessByPoint(nextPoint).filter(c -> c instanceof General).isPresent();
    }

    private boolean onlyTwoGeneralChessInSameCol(Point currentPoint, Point nextPoint) {
        int startY = min(currentPoint.y, nextPoint.y);
        int endY = max(currentPoint.y, nextPoint.y);

        for (int i = startY; i < endY; i++) {
            if (chessBoard.chessExist(currentPoint.x, i)) {
                return false;
            }
        }
        return true;
    }
}
