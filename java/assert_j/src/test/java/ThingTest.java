import org.junit.jupiter.api.Test;

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
        assertThat(result.getPoints().size()).isEqualTo(1);
    }
}
