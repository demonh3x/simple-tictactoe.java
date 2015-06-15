package tictactoe;

import java.util.Arrays;

class Board {
    private char[] placedMarks;

    public Board() {
        placedMarks = new char[9];
    }

    public void placeMarkAtSpace(char mark, int atSpace) {
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
