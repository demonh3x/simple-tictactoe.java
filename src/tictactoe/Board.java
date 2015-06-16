package tictactoe;

import java.util.Arrays;

public class Board {
    private static final int SPACES_AMOUNT = 9;
    private Mark[] placedMarks;

    public static Board empty() {
        return new Board();
    }

    private Board() {
        placedMarks = new Mark[SPACES_AMOUNT];
    }

    public void placeMarkAtSpace(Mark mark, int atSpace) {
        placedMarks[atSpace] = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return Arrays.equals(placedMarks, board.placedMarks);

    }

    @Override
    public int hashCode() {
        return placedMarks != null ? Arrays.hashCode(placedMarks) : 0;
    }

    @Override
    public String toString() {
        return "Board{" +
                "placedMarks=" + Arrays.toString(placedMarks) +
                '}';
    }

}
