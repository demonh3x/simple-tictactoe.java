package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.LiteralBoard.*;

public class GameTest {
    DisplaySpy display;
    Game game;

    @Before
    public void setUp() {
        display = new DisplaySpy();
        game = new Game(display);
    }

    @Test
    public void beforeStartingDoesNotDisplayTheBoard() {
        assertThat(display.isDisplayingABoard).isFalse();
    }

    @Test
    public void afterStartingDisplaysAnEmptyBoard() {
        game.start();
        assertDisplayed(
                "---" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheFirstSpace() {
        game.placeMarkAt(0);
        assertDisplayed(
                "x--" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheSecondSpace() {
        game.placeMarkAt(1);
        assertDisplayed(
                "-x-" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheFifthSpace() {
        game.placeMarkAt(4);
        assertDisplayed(
                "---" +
                "-x-" +
                "---"
        );
    }

    @Test
    public void displaysTheOPlayerInTheSecondSpace() {
        placingMarksAt(0, 1);
        assertDisplayed(
                "xo-" +
                "---" +
                "---"
        );
    }

    private void placingMarksAt(int... spacesToPlaceMarks) {
        for (Integer space : spacesToPlaceMarks)
            game.placeMarkAt(space);
    }

    private void assertDisplayed(String expectedMarks) {
        assertThat(display.board).isEqualTo(createBoardWithMarks(expectedMarks));
    }
}
