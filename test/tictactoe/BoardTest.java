package tictactoe;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void hasLines() {
        assertBoardHasLines(
                "o-x" +
                "ox-" +
                "-x-",
                lines(
                    line(O, NONE, X),
                    line(O, X, NONE),
                    line(NONE, X, NONE),

                    line(O, O, NONE),
                    line(NONE, X, X),
                    line(X, NONE, NONE),

                    line(O, X, NONE),
                    line(X, X, NONE)
                )
        );
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

    private void assertBoardHasLines(String boardMarks, Set<List<Mark>> expectedLines) {
        Board board = createBoardWithMarks(boardMarks);
        assertThat((Set<? extends List<Mark>>) board.lines()).isEqualTo(expectedLines);
    }

    private Set<List<Mark>> lines(final List<Mark>... lines) {
        return new HashSet<List<Mark>>() {{
            addAll(Arrays.asList(lines));
        }};
    }

    private List<Mark> line(Mark first, Mark second, Mark third) {
        return Arrays.asList(first, second, third);
    }
}
