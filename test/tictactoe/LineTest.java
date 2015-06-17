package tictactoe;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class LineTest {
    @Test
    public void aLineConsistingOfTheFirstThreeSpaces() {
        Line line = new Line(
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
        Line line = new Line(
                Arrays.asList(
                        O,    NONE, NONE,
                        NONE, NONE, X,
                        NONE, O,    NONE
                ),
                0, 7, 5
        );
        assertThat(line).isEqualTo(Arrays.asList(O, O, X));
    }

    @Test
    public void aLineWithThreeOMarksIsFullyOccupiedBySameMark() {
        assertThat(isFullyOccupiedBySameMark(O, O, O)).isTrue();
    }

    @Test
    public void aLineWithNoMarksIsNotFullyOccupiedBySameMark() {
        assertThat(isFullyOccupiedBySameMark(NONE, NONE, NONE)).isFalse();
    }

    @Test
    public void aLineWithOnlyTwoMarksIsNotFullyOccupiedBySameMark() {
        assertThat(isFullyOccupiedBySameMark(O, O, NONE)).isFalse();
    }

    private boolean isFullyOccupiedBySameMark(Mark first, Mark second, Mark third) {
        Line line = new Line(
                Arrays.asList(first, second, third),
                0, 1, 2
        );
        return line.isFullyOccupiedBySameMark();
    }

}
