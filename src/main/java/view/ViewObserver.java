package view;

import java.awt.*;

public interface ViewObserver {
    void onUndoChess();
    void onMoveChess(Point selectPoint, Point nextPoint);
}
