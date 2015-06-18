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

    @Test
    public void aFullBoardIsFinishedAndWonByNoOne() {
        Board fullBoard = new Board(Arrays.asList(
                X, X, O,
                O, O, X,
                X, X, O
        ));

        assertThat(fullBoard.isFinished()).isTrue();
        assertThat(fullBoard.getWinner()).isEqualTo(NONE);
    }

    @Test
    public void anAlmostFullBoardIsNotFinishedAndWonByNoOne() {
        Board almostFullBoard = new Board(Arrays.asList(
                NONE, X,    O,
                O,    O,    X,
                X,    X,    O
        ));

        assertThat(almostFullBoard.isFinished()).isFalse();
        assertThat(almostFullBoard.getWinner()).isEqualTo(NONE);
    }

    @Test
    public void aBoardWithALineOccupiedByXIsFinishedAndWonByX() {
        Board boardWithXLine = new Board(Arrays.asList(
                X,    X,    X,
                O,    O,    NONE,
                NONE, NONE, NONE
        ));

        assertThat(boardWithXLine.isFinished()).isTrue();
        assertThat(boardWithXLine.getWinner()).isEqualTo(X);
    }

    @Test
    public void aBoardWithALineOccupiedByOIsFinishedAndWonByO() {
        Board boardWithOLine = new Board(Arrays.asList(
                X,    X,    NONE,
                O,    O,    O,
                X,    NONE, NONE
        ));

        assertThat(boardWithOLine.isFinished()).isTrue();
        assertThat(boardWithOLine.getWinner()).isEqualTo(O);
    }
}
