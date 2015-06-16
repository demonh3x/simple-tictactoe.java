package tictactoe;

class PlayerSpy implements Player {
    public Board lastBoardReceived;

    @Override
    public void placeMark(Board board) {
        lastBoardReceived = board;
    }
}
