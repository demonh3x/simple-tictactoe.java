package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static tictactoe.Mark.*;

public class Board {
    private List<Mark> placedMarks;

    public static Board empty() {
        return new Board(Arrays.asList(
                NONE, NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    private Board(List<Mark> placedMarks) {
        this.placedMarks = placedMarks;
    }

    public void placeMarkAtSpace(Mark mark, int atSpace) {
        placedMarks.set(atSpace, mark);
    }

    public Board withMarkAtSpace(Mark mark, int atSpace) {
        List<Mark> marks = new ArrayList<>(placedMarks);
        marks.set(atSpace, mark);
        return new Board(marks);
    }

    public List<Mark> marks() {
        return placedMarks;
    }
}
