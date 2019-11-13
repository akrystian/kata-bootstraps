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
}
