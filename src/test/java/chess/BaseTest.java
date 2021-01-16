package chess;

import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BaseTest {
    protected void assertPointAt( Point expectedPoint, Point actualPoint) {
        assertPointAt(actualPoint.x, actualPoint.y, expectedPoint);
    }
    protected void assertPointAt(int x, int y, Point point) {
        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
    }
}
