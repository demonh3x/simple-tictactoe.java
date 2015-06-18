package tictactoe;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class HumanPlayerTest {
    @Test
    public void printsAMessageAskingToSelectASpace() {
        Board board = new Board(Arrays.asList(
                NONE, NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
        String outputText = getOutputAfterPlayingWithInput(board, X, "0\n");
        assertThat(outputText).isEqualTo("Choose space: [0, 1, 2, 3, 4, 5, 6, 7, 8]\n");
    }

    @Test
    public void whenTheHumanAsXInputs0PlacesTheMarkAtTheFirstSpace() {
        List<Mark> marks = getMarksAfterPlayingWithInput(
                new Board(Arrays.asList(
                        NONE, NONE, NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                )),
                X,
                "0\n"
        );
        assertThat(marks).isEqualTo(Arrays.asList(
                X,    NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    @Test
    public void whenTheHumanAsOInputs1PlacesTheMarkAtTheSecondSpace() {
        List<Mark> marks = getMarksAfterPlayingWithInput(
                new Board(Arrays.asList(
                        NONE, NONE, NONE,
                        NONE, NONE, NONE,
                        NONE, NONE, NONE
                )),
                O,
                "1\n"
        );
        assertThat(marks).isEqualTo(Arrays.asList(
                NONE, O,    NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    @Test
    public void whenTheHumanIntroducesAnInvalidSpacePrintsAMessageSayingItAndAsksAgain() {
        Board board = new Board(Arrays.asList(
                X,    O,    NONE,
                NONE, NONE, NONE,
                NONE, X,    O
        ));
        String outputText = getOutputAfterPlayingWithInput(board, X, "9\n0\nfoo\n2\n");
        assertThat(outputText).isEqualTo(
                "Choose space: [2, 3, 4, 5, 6]\n" +
                "Sorry, that is not possible. Please try again.\n" +
                "Choose space: [2, 3, 4, 5, 6]\n" +
                "Sorry, that is not possible. Please try again.\n" +
                "Choose space: [2, 3, 4, 5, 6]\n" +
                "Sorry, that is not possible. Please try again.\n" +
                "Choose space: [2, 3, 4, 5, 6]\n"
        );
    }

    private String getOutputAfterPlayingWithInput(Board board, Mark mark, String userInput) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        HumanPlayer player = new HumanPlayer(mark, out, in);
        player.placeMark(board);
        return out.toString();
    }

    private List<Mark> getMarksAfterPlayingWithInput(Board board, Mark mark, String userInput) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());

        HumanPlayer player = new HumanPlayer(mark, out, in);

        Board updatedBoard = player.placeMark(board);
        return updatedBoard.marks();
    }
}
