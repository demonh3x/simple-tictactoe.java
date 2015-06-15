package tictactoe;

public class DisplaySpy implements Display {
    public Board board;
    public boolean isDisplayingABoard = false;

    @Override
    public void updateBoard(Board board) {
        this.board = board;
        this.isDisplayingABoard = true;
    }
}
