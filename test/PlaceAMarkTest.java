import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceAMarkTest {
    @Test
    public void showsTheXPlayerInTheFirstSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();
        game.placeMark(0);

        assertThat(display.shownBoard).isEqualTo(
                "x--" +
                "---" +
                "---"
        );
    }

    @Test
    public void showsTheXPlayerInTheSecondSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();
        game.placeMark(1);

        assertThat(display.shownBoard).isEqualTo(
                "-x-" +
                "---" +
                "---"
        );
    }

    @Test
    public void showsTheXPlayerInTheFifthSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();
        game.placeMark(4);

        assertThat(display.shownBoard).isEqualTo(
                "---" +
                "-x-" +
                "---"
        );
    }
}
