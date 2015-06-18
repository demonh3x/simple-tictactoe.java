package tictactoe;

public class ComputerPlayer implements Player {
    private final Mark mark;

    public ComputerPlayer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public Board placeMark(Board board) {
        return board.withMarkAtSpace(mark, board.availableSpaces().get(0));
    }
}
