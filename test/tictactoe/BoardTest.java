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
    public void aFullBoardWithNoMarkFullyOccupyingALineIsADraw() {
        Board fullBoard = new Board(Arrays.asList(
                X, X, O,
                O, O, X,
                X, X, O
        ));

        assertIsADraw(fullBoard);
    }

    @Test
    public void anAlmostFullBoardWithNoMarkFullyOccupyingALineIsOngoing() {
        Board almostFullBoard = new Board(Arrays.asList(
                NONE, X,    O,
                O,    O,    X,
                X,    X,    O
        ));

        assertOngoing(almostFullBoard);
    }

    @Test
    public void aBoardWithTheOMarkFullyOccupyingALineIsWonByO() {
        Board boardWithOLine = new Board(Arrays.asList(
                X,    X,    NONE,
                O,    O,    O,
                X,    NONE, NONE
        ));

        assertWonBy(O, boardWithOLine);
    }

    @Test
    public void aBoardWithTheXMarkFullyOccupyingALineIsWonByX() {
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        X,    X,    X,
                        O,    O,    NONE,
                        NONE, NONE, NONE
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        O,    O,    NONE,
                        X,    X,    X,
                        NONE, NONE, NONE
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        O,    O,    NONE,
                        NONE, NONE, NONE,
                        X,    X,    X
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        X,    O,    O,
                        X,    NONE, NONE,
                        X,    NONE, NONE
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        O,    X,    O,
                        NONE, X,    NONE,
                        NONE, X,    NONE
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        O,    O,    X,
                        NONE, NONE, X,
                        NONE, NONE, X
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        X,    O,    O,
                        NONE, X,    NONE,
                        NONE, NONE, X
                ))
        );
        assertWonBy(
                X,
                new Board(Arrays.asList(
                        NONE, NONE, X,
                        NONE, X,    O,
                        X,    NONE, O
                ))
        );
    }

    private void assertIsADraw(Board board) {
        assertThat(board.isFinished()).isTrue();
        assertThat(board.getWinner()).isEqualTo(NONE);
    }

    private void assertOngoing(Board board) {
        assertThat(board.isFinished()).isFalse();
        assertThat(board.getWinner()).isEqualTo(NONE);
    }

    private void assertWonBy(Mark winner, Board board) {
        assertThat(board.isFinished()).isTrue();
        assertThat(board.getWinner()).isEqualTo(winner);
    }
}
