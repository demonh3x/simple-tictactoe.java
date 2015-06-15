package tictactoe;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerStub implements Player {
    private char mark;
    private Queue<Integer> spacesToPlaceMarks;

    public PlayerStub(char mark) {
        this.mark = mark;
        this.spacesToPlaceMarks = new LinkedList<>();
    }

    @Override
    public void placeMark(Board board) {
        board.placeMarkAt(mark, spacesToPlaceMarks.poll());
    }

    public void willPlaceMarkAt(int space) {
        spacesToPlaceMarks.add(space);
    }
}
