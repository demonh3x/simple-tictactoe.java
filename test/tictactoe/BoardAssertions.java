package tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class BoardAssertions {
    public static final char EMPTY_SPACE = '-';

    public static void assertBoardContainsMarks(Board actualBoard, String expectedMarks) {
        assertThat(actualBoard.marks()).isEqualTo(createBoardWithMarks(expectedMarks).marks());
    }

    private static Board createBoardWithMarks(String marks) {
        Board board = Board.empty();

        for (int space = 0; space < marks.length(); space++) {
            char symbol = marks.charAt(space);
            if (symbol != EMPTY_SPACE)
                board = board.withMarkAtSpace(markFrom(symbol), space);
        }

        return board;
    }

    private static Mark markFrom(char symbol) {
        switch (symbol){
            case 'x':
                return X;
            case 'o':
                return O;
            default:
                throw new IllegalArgumentException(String.format("The symbol %s is not a mark!", symbol));
        }
    }
}