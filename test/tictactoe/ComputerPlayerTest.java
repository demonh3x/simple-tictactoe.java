package tictactoe;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class ComputerPlayerTest {
    @Test
    public void playsTheFirstSpaceInAnEmptyBoard() {
        List<Mark> marks = getMarksAfterPlaying(
                new Board(Arrays.asList(
                        NONE, NONE, NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                )),
                X
        );
        assertThat(marks).isEqualTo(Arrays.asList(
                X,    NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    @Test
    public void playsTheSecondSpaceWhenTheFirstSpaceIsOccupied() {
        List<Mark> marks = getMarksAfterPlaying(
                new Board(Arrays.asList(
                        X,    NONE, NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                )),
                O
        );
        assertThat(marks).isEqualTo(Arrays.asList(
                X,    O,    NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    @Test
    public void playsTheThirdSpaceWhenTheFirstTwoSpacesAreOccupied() {
        List<Mark> marks = getMarksAfterPlaying(
                new Board(Arrays.asList(
                        X,    O,    NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                )),
                X
        );
        assertThat(marks).isEqualTo(Arrays.asList(
                X,    O,    X,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    private List<Mark> getMarksAfterPlaying(Board board, Mark mark) {
        ComputerPlayer player = new ComputerPlayer(mark);
        Board boardAfterPlaying = player.placeMark(board);
        return boardAfterPlaying.marks();
    }
}
