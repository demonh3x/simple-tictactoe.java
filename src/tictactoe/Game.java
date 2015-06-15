package tictactoe;

public class Game {
    private Display display;
    private Board board;
    private char nextMark;

    public Game(Display display) {
        this.display = display;
        this.board = new Board();
        this.nextMark = 'x';
    }

    public void start() {
        display.updateBoard(board);
    }

    public void placeMarkAt(int space) {
        board.placeMarkAt(nextMark, space);
        display.updateBoard(board);
        nextMark = 'o';
    }
}
