package tictactoe;

public class Game {
    private Display display;
    private Turns turns;
    private Board board;

    public Game(Display display, Turns turns) {
        this.display = display;
        this.turns = turns;
        this.board = new Board();
    }

    public void start() {
        display.updateBoard(board);
    }

    public void step() {
        turns.nextPlayer().placeMark(board);
        display.updateBoard(board);
    }
}
