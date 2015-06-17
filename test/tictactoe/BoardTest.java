package tictactoe;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class BoardTest {
    @Test
    public void anEmptyBoardContainsNoMarks() {
        Board emptyBoard = Board.empty();
        assertThat(emptyBoard.marks()).isEqualTo(Arrays.asList(
                NONE, NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    @Test
    public void aBoardWithXMarkAtFirstSpace() {
        Board board = Board.empty().withMarkAtSpace(X, 0);
        assertThat(board.marks()).isEqualTo(Arrays.asList(
                X,    NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    @Test
    public void addingAMarkDoesNotChangeTheFactThatTheBoardDidNotContainItBefore() {
        Board previousBoard = Board.empty();
        previousBoard.withMarkAtSpace(X, 0);
        assertThat(previousBoard.marks()).isEqualTo(Arrays.asList(
                NONE, NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }
}
