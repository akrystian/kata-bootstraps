import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ThingTest {
    @Test
    public void shouldEvaluateEmptyBoard() {
        //given
        final var empty = Board.empty();

        //when
        Board result = empty.iterate();

        //then
        assertThat(result).isEqualTo(Board.empty());
    }

    @Test
    public void shouldAddSinglePointToBoard() {
        //given
        final var board = Board.empty();

        //when
        Board result = board.add(new Point(0, 0));

        //then
        final var points = result.getPoints();
        assertThat(points.size()).isEqualTo(1);
        assertThat(points).containsExactly(new Point(0, 0));
    }

    @Test
    public void shouldDieOfUnderpopulation() {
        //given
        Board board = Board.empty().add(new Point(0, 0));

        //when
        final var result = board.iterate();

        //then
        final var points = result.getPoints();
        assertThat(points.size()).isEqualTo(0);
    }

    @Test
    public void shouldDieOfUnderpopulationTwo() {
        //given
        Board board = Board.empty().add(new Point(0, 0)).add(Point.of(5, 5));

        //when
        final var result = board.iterate();

        //then
        final var points = result.getPoints();
        assertThat(points.size()).isEqualTo(0);
    }


    @Test
    public void shouldPersistPopulation() {
        //given
        Board board = Board.empty()
                .add(new Point(0, 0))
                .add(Point.of(1, 1))
                .add(Point.of(1, 0))
                .add(Point.of(0, 1));
        //when
        final var result = board.iterate();

        //then
        final var points = result.getPoints();
        assertThat(points.size()).isEqualTo(4);
    }

    @Test
    public void shouldFindNumberOfNeighbours() {
        //given
        final var point = new Point(0, 0);
        final var points = Set.of(point);
        final var neigbourFinder = new NeigbourFinder(points);

        //when
        int result = neigbourFinder.find(point);

        //then
        assertThat(result).isEqualTo(0);
    }
}
