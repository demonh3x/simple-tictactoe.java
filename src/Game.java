public class Game {
    private final Display display;

    public Game(Display display) {
        this.display = display;
    }

    public void start() {
        display.updateBoard("---------");
    }

    public void placeMark(int inSpace) {
        String board = "---------";
        board = board.substring(0, inSpace) + "x" + board.substring(inSpace +1);
        display.updateBoard(board);
    }
}
