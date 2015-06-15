public class Game {
    private Display display;
    private Board board;

    public Game(Display display) {
        this.display = display;
        this.board = new Board();
    }

    public void start() {
        display.updateBoard(board.marks());
    }

    public void placeMarkAt(int space) {
        board.placeMarkAt(space);
        display.updateBoard(board.marks());
    }
}
