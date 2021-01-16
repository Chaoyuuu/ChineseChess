package view;

import java.awt.*;

import static view.Utils.*;

public class SelectedBox {
    private Point gamePoint;

    public SelectedBox(Point point) {
        this.gamePoint = mapPointFromViewToGame(point);
    }

    public int getX() {
        return mapXFromGameToView(gamePoint.x);
    }

    public int getY() {
        return mapYFromGameToView(gamePoint.y);
    }

    public void setPoint(Point viewPoint) {
        this.gamePoint = mapPointFromViewToGame(viewPoint);
    }
}
