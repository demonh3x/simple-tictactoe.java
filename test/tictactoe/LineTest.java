package tictactoe;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class LineTest {
    @Test
    public void aLineConsistingOfTheFirstThreeSpaces() {
        List<Mark> line = new Line(
                Arrays.asList(
                        X,    O,    NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                ),
                0, 1, 2
        );
        assertThat(line).isEqualTo(Arrays.asList(X, O, NONE));
    }

    @Test
    public void aLineConsistingOfThreeArbitrarySpaces() {
        List<Mark> line = new Line(
                Arrays.asList(
                        O,    NONE, NONE,
                        NONE, NONE, X,
                        NONE, O,    NONE
                ),
                0, 7, 5
        );
        assertThat(line).isEqualTo(Arrays.asList(O, O, X));
    }

}
