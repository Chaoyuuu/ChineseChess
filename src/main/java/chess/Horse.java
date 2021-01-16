package chess;

import java.awt.*;

public class Horse extends Chess {
    private Point obstaclePoint = new Point();
    private Point newPoint = new Point();
    private final Integer[] offsetX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final Integer[] offsetY = {1, 2, 2, 1, -1, -2, -2, -1};
    private final Integer[] obstacleX = {1, 0, 0, -1, -1, 0, 0, 1};
    private final Integer[] obstacleY = {0, 1, 1, 0, 0, -1, -1, 0};

    public Horse(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        for (int i = 0; i < offsetX.length; i++) {
            obstaclePoint.setLocation(currentPoint.x + obstacleX[i], currentPoint.y + obstacleY[i]);
            newPoint.setLocation(currentPoint.x + offsetX[i], currentPoint.y + offsetY[i]);
            if (nextPoint.equals(newPoint) && !chessBoard.chessExist(obstaclePoint)) {
                return true;
            }
        }
        return false;
    }
}
