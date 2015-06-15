public class Game {
    private static final String EMPTY_BOARD = "---------";
    private final Display display;

    public Game(Display display) {
        this.display = display;
    }

    public void start() {
        display.updateBoard(EMPTY_BOARD);
    }

    public void placeMarkAt(int space) {
        display.updateBoard(boardWithMarkXInsertedAt(space));
    }

    private String boardWithMarkXInsertedAt(int space) {
        String board = EMPTY_BOARD;
        String marksBeforeTheSpace = board.substring(0, space);
        String marksAfterTheSpace = board.substring(space + 1);

        return marksBeforeTheSpace + "x" + marksAfterTheSpace;
    }
}
