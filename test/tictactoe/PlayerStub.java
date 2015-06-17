package tictactoe;

import java.util.LinkedList;
import java.util.Queue;

public class PlayerStub implements Player {
    private Mark mark;
    private Queue<Integer> spacesToPlaceMarks;

    public PlayerStub(Mark mark) {
        this.mark = mark;
        this.spacesToPlaceMarks = new LinkedList<>();
    }

    @Override
    public Board placeMark(Board board) {
        return board.withMarkAtSpace(mark, chosenSpace());
    }

    private Integer chosenSpace() {
        return spacesToPlaceMarks.poll();
    }

    public void willPlaceMarkAt(int space) {
        spacesToPlaceMarks.add(space);
    }
}
