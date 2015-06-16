package tictactoe;

import static tictactoe.Mark.*;

public class LiteralBoard {
    public static final char EMPTY_SPACE = '-';

    public static Board createBoardWithMarks(String marks) {
        Board board = new Board();

        for (int space = 0; space < marks.length(); space++) {
            char symbol = marks.charAt(space);
            if (symbol != EMPTY_SPACE)
                board.placeMarkAtSpace(markFrom(symbol), space);
        }

        return board;
    }

    public static Mark markFrom(char symbol) {
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