import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartGameTest {
    public static final String EMPTY_BOARD =
            "---" +
            "---" +
            "---";

    @Test
    public void displaysAnEmptyBoard() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();

        assertThat(display.board).isEqualTo(EMPTY_BOARD);
    }

    @Test
    public void doesNotDisplayTheBoardBeforeStarting() {
        DisplaySpy display = new DisplaySpy();
        new Game(display);

        assertThat(display.isDisplayingABoard).isFalse();
    }
}
