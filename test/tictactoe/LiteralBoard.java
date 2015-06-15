package tictactoe;

public class LiteralBoard {
    public static Board createBoardWithMarks(String marks) {
        Board board = new Board();

        for (int i = 0; i < marks.length(); i++) {
            char mark = marks.charAt(i);
            if (mark != '-')
                board.placeMarkAt(mark, i);
        }

        return board;
    }
}