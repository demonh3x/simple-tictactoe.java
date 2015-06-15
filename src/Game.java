public class Game {
    private final Display display;

    public Game(Display display) {
        this.display = display;
    }

    public void start() {
        display.updateBoard("---------");
    }

    public void placeMark(int atSpace) {
        String board = "---------";
        board = board.substring(0, atSpace) + "x" + board.substring(atSpace +1);
        display.updateBoard(board);
    }
}
