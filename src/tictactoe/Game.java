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
        display.updateBoard(board);
    }

    public void step() {
        turns.nextPlayer().placeMark(board);
        display.updateBoard(board);
    }
}
