package tictactoe;

public class Game {
    private Board board;
    private Display display;
    private ActivePlayer activePlayer;

    public Game(Board board, Display display, ActivePlayer activePlayer) {
        this.board = board;
        this.display = display;
        this.activePlayer = activePlayer;
    }

    public void start() {
        displayBoard();
    }

    public void doTurn() {
        giveTurnToActivePlayer();
        displayBoard();
    }

    private void giveTurnToActivePlayer() {
        activePlayer.placeMark(board);
        activePlayer.changeToNext();
    }

    private void displayBoard() {
        display.updateBoard(board);
    }
}
