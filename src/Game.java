public class Game {
    private Display display;
    private Board board;

    public Game(Display display) {
        this(display, new Board());
    }

    public Game(Display display, Board board) {
        this.display = display;
        this.board = board;
    }

    public void start() {
        display.updateBoard(board.placedMarks());
    }

    public void placeMarkAt(int space) {
        board.placeNextMarkAt(space);
        display.updateBoard(board.placedMarks());
    }
}
