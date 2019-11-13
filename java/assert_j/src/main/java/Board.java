
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board {
    Set<Point> points = new HashSet<>();

    public static Board empty() {
        return new Board();
    }

    public Board iterate() {
        NeigbourFinder neigbourFinder = new NeigbourFinder(points);
        final Map<Integer, Point> collect = points.stream()

                .collect(Collectors.toMap(neigbourFinder::find, Function.identity()));
        points.remove(collect.get(0));

        return this;
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
        points.add(point);
        return this;
    }

    public Set<Point> getPoints() {
        return Set.copyOf(points);
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
}








