package tictactoe;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TestingBoard {
    public static void assertBoardContainsMarks(Board actualBoard, Mark... expectedMarks) {
        assertThat(actualBoard.marks()).isEqualTo(new Board(Arrays.asList(expectedMarks)).marks());
    }
}