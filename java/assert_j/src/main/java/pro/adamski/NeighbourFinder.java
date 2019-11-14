package pro.adamski;

import java.util.Set;

public class NeighbourFinder {
    private final Set<Point> points;

    public NeighbourFinder(final Set<Point> points) {
        this.points = Set.copyOf(points);
    }

    public int find(Point point) {
        final int x = point.getX();
        final int y = point.getY();
        int count = 0;
        if (points.contains(Point.of(x + 1, y + 1))) {
            count++;
        }
        if (points.contains(Point.of(x, y + 1))) {
            count++;
        }
        if (points.contains(Point.of(x - 1, y + 1))) {
            count++;
        }
        if (points.contains(Point.of(x + 1, y))) {
            count++;
        }
        if (points.contains(Point.of(x - 1, y))) {
            count++;
        }
        if (points.contains(Point.of(x + 1, y - 1))) {
            count++;
        }
        if (points.contains(Point.of(x, y - 1))) {
            count++;
        }
        if (points.contains(Point.of(x - 1, y - 1))) {
            count++;
        }
        return count;
    }
}
