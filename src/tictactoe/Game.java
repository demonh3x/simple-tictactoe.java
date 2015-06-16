package tictactoe;

public class Game {
    private Board board;
    private Display display;
    private Turns turns;

    public Game(Board board, Display display, Turns turns) {
        this.board = board;
        this.display = display;
        this.turns = turns;
    }

    public void start() {
        displayBoard();
    }

    public void step() {
        giveTurn();
        displayBoard();
    }

    private void giveTurn() {
        nextPlayer().placeMark(board);
    }

    private Player nextPlayer() {
        return turns.nextPlayer();
    }

    private void displayBoard() {
        display.updateBoard(board);
    }
}
