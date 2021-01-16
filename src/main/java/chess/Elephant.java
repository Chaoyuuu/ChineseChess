package chess;

import java.awt.*;

public class Elephant extends Chess {
    private Point obstaclePoint = new Point();
    private Point newPoint = new Point();
    private final Integer[] offsetX = {2, -2, -2, 2};
    private final Integer[] offsetY = {2, 2, -2, -2};
    private final Integer[] obstacleX = {1, -1, -1, 1};
    private final Integer[] obstacleY = {1, 1, -1, -1};

    public Elephant(ChessColor chessColor, Point point) {
        super(chessColor, point);
    }

    @Override
    public boolean validMove(Point nextPoint) {
        for (int i = 0; i < offsetX.length; i++) {
            obstaclePoint.setLocation(currentPoint.x + obstacleX[i], currentPoint.y + obstacleY[i]);
            newPoint.setLocation(currentPoint.x + offsetX[i], currentPoint.y + offsetY[i]);
            if (newPoint.equals(nextPoint) && !chessBoard.chessExist(obstaclePoint)) {
                return true;
            }
        }
        return false;
    }
}
