package tictactoe;

import java.util.*;

import static tictactoe.Mark.*;

public class Board {
    public static Board empty() {
        return new Board(Arrays.asList(
                NONE, NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        ));
    }

    private final List<Mark> placedMarks;

    private Board(List<Mark> placedMarks) {
        this.placedMarks = placedMarks;
    }

    public List<Mark> marks() {
        return placedMarks;
    }

    public Board withMarkAtSpace(Mark mark, int atSpace) {
        List<Mark> marks = new ArrayList<>(placedMarks);
        marks.set(atSpace, mark);
        return new Board(marks);
    }

    public Set<Line> lines() {
        return new HashSet<Line>() {{
            add(lineAtSpaces(0, 1, 2));
            add(lineAtSpaces(3, 4, 5));
            add(lineAtSpaces(6, 7, 8));

            add(lineAtSpaces(0, 3, 6));
            add(lineAtSpaces(1, 4, 7));
            add(lineAtSpaces(2, 5, 8));

            add(lineAtSpaces(0, 4, 8));
            add(lineAtSpaces(2, 4, 6));
        }};
    }

    private Line lineAtSpaces(int... atSpaces) {
        return new Line(placedMarks, atSpaces);
    }

    public Mark getWinner() {
        for (Line line : lines())
            if (line.isFullyOccupiedBySameMark())
                return line.firstMark();

        return NONE;
    }

    public boolean isFinished() {
        return hasAWinner() || isFull();
    }

    private boolean hasAWinner() {
        return getWinner() != NONE;
    }

    private boolean isFull() {
        return !placedMarks.contains(NONE);
    }
}
