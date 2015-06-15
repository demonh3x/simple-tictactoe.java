import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameTest {
    public static final String EMPTY_BOARD =
            "---" +
            "---" +
            "---";

    @Test
    public void showsAnEmptyBoard() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();

        assertThat(display.shownBoard).isEqualTo(EMPTY_BOARD);
    }

    @Test
    public void doesNotShowAnythingBeforeStarting() {
        DisplaySpy display = new DisplaySpy();
        new Game(display);

        assertThat(display.hasShownSomething).isFalse();
    }
}
