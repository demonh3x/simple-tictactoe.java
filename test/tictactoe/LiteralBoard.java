package tictactoe;

public class LiteralBoard {
    public static final char EMPTY_SPACE = '-';

    public static Board createBoardWithMarks(String marks) {
        Board board = new Board();

        for (int space = 0; space < marks.length(); space++) {
            char mark = marks.charAt(space);
            if (mark != EMPTY_SPACE)
                board.placeMarkAtSpace(mark, space);
        }

        return board;
    }
}