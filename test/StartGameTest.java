import org.junit.Test;

public class StartGameTest {
    public static final String EMPTY_BOARD =
            "---" +
            "---" +
            "---";

    @Test
    public void showsAnEmptyBoard() {
        DisplayMock display = new DisplayMock();
        Game game = new Game(display);

        game.start();

        display.shouldHaveShown(EMPTY_BOARD);
    }

    @Test
    public void doesNotShowAnythingBeforeStarting() {
        DisplayMock display = new DisplayMock();
        new Game(display);

        display.shouldNotHaveShownAnything();
    }
}
