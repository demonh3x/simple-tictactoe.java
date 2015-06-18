package tictactoe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class CliDisplayTest {
    @Test
    public void displaysAnEmptyBoard() {
        assertPrintedBoard(
                new Board(Arrays.asList(
                        NONE, NONE, NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                )),
                "---\n" +
                "---\n" +
                "---\n"
        );
    }

    @Test
    public void displaysABoardWithSomeMarks() {
        assertPrintedBoard(
                new Board(Arrays.asList(
                        X,    NONE, X,
                        NONE, O,    NONE,
                        NONE, O,    NONE
                )),
                "x-x\n" +
                "-o-\n" +
                "-o-\n"
        );
    }

    @Test
    public void displaysThePlayerXAsTheWinner() {
        assertPrintedBoard(
                new Board(Arrays.asList(
                        X,    X,    X,
                        NONE, O,    NONE,
                        NONE, O,    NONE
                )),
                "xxx\n" +
                "-o-\n" +
                "-o-\n" +
                "Player x has won!\n"
        );
    }

    @Test
    public void displaysThePlayerOAsTheWinner() {
        assertPrintedBoard(
                new Board(Arrays.asList(
                        X,    O,    X,
                        X,    O,    NONE,
                        NONE, O,    NONE
                )),
                "xox\n" +
                "xo-\n" +
                "-o-\n" +
                "Player o has won!\n"
        );
    }

    @Test
    public void displaysADraw() {
        assertPrintedBoard(
                new Board(Arrays.asList(
                        X, X, O,
                        O, O, X,
                        X, O, X
                )),
                "xxo\n" +
                "oox\n" +
                "xox\n" +
                "It is a draw!\n"
        );
    }

    private void assertPrintedBoard(Board board, String expectedPrintedOutput) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        new CliDisplay(output).updateBoard(board);
        assertThat(output.toString()).isEqualTo(expectedPrintedOutput);
    }
}
