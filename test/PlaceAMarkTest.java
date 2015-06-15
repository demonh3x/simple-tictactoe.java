import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceAMarkTest {
    @Test
    public void displaysTheXPlayerInTheFirstSpace() {
        assertDisplayedBoardAfterPlacingFirstMarkAt(
                0,
                "x--" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheSecondSpace() {
        assertDisplayedBoardAfterPlacingFirstMarkAt(
                1,
                "-x-" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheFifthSpace() {
        assertDisplayedBoardAfterPlacingFirstMarkAt(
                4,
                "---" +
                "-x-" +
                "---"
        );
    }

    private void assertDisplayedBoardAfterPlacingFirstMarkAt(
            int space, String expectedDisplayedBoard) {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.placeMarkAt(space);

        assertThat(display.board).isEqualTo(expectedDisplayedBoard);
    }

    @Test
    public void displaysTheOPlayerInTheSecondSpace() {
        DisplaySpy display = new DisplaySpy();
        Game game = new Game(display);

        game.placeMarkAt(0);
        game.placeMarkAt(1);

        assertThat(display.board).isEqualTo(
                "xo-" +
                "---" +
                "---"
        );
    }
}
