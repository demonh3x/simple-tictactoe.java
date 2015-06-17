package tictactoe;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;
import static tictactoe.TestingBoard.*;

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
        Board fullBoard = createBoardWithMarks(
                "xxo" +
                "oox" +
                "xxo"
        );

        assertThat(fullBoard.isFinished()).isTrue();
        assertThat(fullBoard.getWinner()).isEqualTo(NONE);
    }

    @Test
    public void anAlmostFullBoardIsNotFinishedAndWonByNoOne() {
        Board almostFullBoard = createBoardWithMarks(
                "-xo" +
                "oox" +
                "xxo"
        );

        assertThat(almostFullBoard.isFinished()).isFalse();
        assertThat(almostFullBoard.getWinner()).isEqualTo(NONE);
    }

    @Test
    public void aBoardWithALineOccupiedByXIsFinishedAndWonByX() {
        Board boardWithXLine = createBoardWithMarks(
                "xxx" +
                "oo-" +
                "---"
        );

        assertThat(boardWithXLine.isFinished()).isTrue();
        assertThat(boardWithXLine.getWinner()).isEqualTo(X);
    }

    @Test
    public void aBoardWithALineOccupiedByOIsFinishedAndWonByO() {
        Board boardWithXLine = createBoardWithMarks(
                "xx-" +
                "ooo" +
                "x--"
        );

        assertThat(boardWithXLine.isFinished()).isTrue();
        assertThat(boardWithXLine.getWinner()).isEqualTo(O);
    }
}
