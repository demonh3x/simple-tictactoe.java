import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceAMarkTest {
    @Test
    public void displaysTheXPlayerInTheFirstSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();
        game.placeMark(0);

        assertThat(display.board).isEqualTo(
                "x--" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheSecondSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();
        game.placeMark(1);

        assertThat(display.board).isEqualTo(
                "-x-" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheFifthSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.start();
        game.placeMark(4);

        assertThat(display.board).isEqualTo(
                "---" +
                "-x-" +
                "---"
        );
    }
}
