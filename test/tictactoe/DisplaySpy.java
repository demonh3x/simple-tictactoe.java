package tictactoe;

public class DisplaySpy implements Display {
    private boolean updateBoardCalled = false;
    private Board board;

    @Override
    public void updateBoard(Board board) {
        this.board = board;
        this.updateBoardCalled = true;
    }

    public boolean hasUpdateBoardBeenCalled() {
        return updateBoardCalled;
    }

    public Board displayedBoard() {
        return board;
    }
}
