public class Game {
    private Display display;
    private Board board;

    public Game(Display display) {
        this.display = display;
        this.board = new Board();
    }

    public void start() {
        display.updateBoard(board.placedMarks());
    }

    public void placeMarkAt(int space) {
        board.placeNextMarkAt(space);
        display.updateBoard(board.placedMarks());
    }
}
