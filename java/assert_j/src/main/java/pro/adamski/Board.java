package pro.adamski;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;

public class Board {
    Set<Point> points;

    private Board(Set<Point> points) {
        this.points = points;
    }

    public static Board empty() {
        return new Board(emptySet());
    }

    public Board iterate() {
        NeighbourFinder neighbourFinder = new NeighbourFinder(points);

        final Set<Point> dieCells = prepareDeadCells(neighbourFinder);

        final Set<Point> newCells = prepareBirthCells(neighbourFinder);

        final HashSet<Point> newPoints = new HashSet<>(this.points);
        newPoints.removeAll(dieCells);
        newPoints.addAll(newCells);
        return new Board(newPoints);
    }

    private Set<Point> prepareBirthCells(NeighbourFinder neighbourFinder) {
        return points.stream().map(CellProposer::new)
                .flatMap(it -> it.propose().stream())
                .filter(it -> !points.contains(it))
                .map(it -> PointNeghbours.of(it, neighbourFinder.find(it)))
                .filter(it -> (it.getNeghboursCount() == 3))
                .map(PointNeghbours::getPoint)
                .collect(Collectors.toSet());
    }

    private Set<Point> prepareDeadCells(NeighbourFinder neighbourFinder) {
        return points.stream()
                .map(it -> PointNeghbours.of(it, neighbourFinder.find(it)))
                .filter(it -> (it.getNeghboursCount() < 2 || it.getNeghboursCount() > 3))
                .map(PointNeghbours::getPoint)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(points, board.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    public Board add(Point point) {
        final HashSet<Point> newPoints = new HashSet<>(this.points);
        newPoints.add(point);
        return new Board(newPoints);
    }

    public Set<Point> getPoints() {
        return Set.copyOf(points);
    }
}

class CellProposer {
    private final Point center;

    CellProposer(Point center) {
        this.center = center;
    }

    Set<Point> propose() {
        final int x = center.getX();
        final int y = center.getY();

        return Set.of(Point.of(x + 1, y),
                Point.of(x - 1, y),
                Point.of(x, y - 1),
                Point.of(x, y + 1),

                Point.of(x - 1, y - 1),
                Point.of(x + 1, y + 1),
                Point.of(x - 1, y + 1),
                Point.of(x + 1, y - 1));
    }

}

class PointNeghbours {
    private final Point point;
    private final int neghboursCount;

    PointNeghbours(Point point, int neghboursCount) {
        this.point = point;
        this.neghboursCount = neghboursCount;
    }

    static PointNeghbours of(Point point, int neghboursCount) {
        return new PointNeghbours(point, neghboursCount);
    }

    public Point getPoint() {
        return point;
    }

    public int getNeghboursCount() {
        return neghboursCount;
    }
}

class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Point of(int x, int y) {
        return new Point(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" + x +
                "," + y +
                '}';
    }
}








