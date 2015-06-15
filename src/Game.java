public class Game {
    private static final String EMPTY_BOARD = "---------";

    private Display display;
    private String board;
    private String mark;

    public Game(Display display) {
        this.display = display;
        this.board = EMPTY_BOARD;
        this.mark = "x";
    }

    public void start() {
        display.updateBoard(EMPTY_BOARD);
    }

    public void placeMarkAt(int space) {
        insertMarkAt(space);
        advanceMark();
        display.updateBoard(board);
    }

    private void insertMarkAt(int space) {
        String marksBeforeTheSpace = board.substring(0, space);
        String marksAfterTheSpace = board.substring(space + 1);
        board = marksBeforeTheSpace + mark + marksAfterTheSpace;
    }

    private void advanceMark() {
        mark = "o";
    }
}
