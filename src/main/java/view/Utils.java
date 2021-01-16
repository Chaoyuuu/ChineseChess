package view;

import java.awt.*;

public class Utils {
    public static int mapXFromGameToView(int x) {
        return 30 + x * 59;
    }

    public static int mapYFromGameToView(int y) {
        y = Math.abs(y - 9);
        if (y <= 4) {
            y = 18 + y * 59;
        } else {
            y = 28 + y * 59;
        }
        return y;
    }

    public static Point mapPointFromGameToView(Point point) {
        return new Point(mapXFromGameToView(point.x), mapYFromGameToView(point.y));
    }

    public static Point mapPointFromViewToGame(Point point) {
        int x = (point.x - 30) / 59;
        int y = (point.y - 30) / 59;
        return new Point(x, Math.abs(y - 9));
    }
}
