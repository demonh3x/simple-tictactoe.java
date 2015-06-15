package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.LiteralBoard.*;

public class GameTest {
    PlayerStub x, o;
    DisplaySpy display;
    Game game;

    @Before
    public void setUp() {
        x = new PlayerStub('x');
        o = new PlayerStub('o');
        display = new DisplaySpy();
        game = new Game(new Board(), display, new Turns(x, o));
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
        x.willPlaceMarkAt(0);
        game.step();
        assertDisplayed(
                "x--" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheSecondSpace() {
        x.willPlaceMarkAt(1);
        game.step();
        assertDisplayed(
                "-x-" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheFifthSpace() {
        x.willPlaceMarkAt(4);
        game.step();
        assertDisplayed(
                "---" +
                "-x-" +
                "---"
        );
    }

    @Test
    public void displaysTheOPlayerInTheSecondSpace() {
        x.willPlaceMarkAt(0);
        game.step();
        o.willPlaceMarkAt(1);
        game.step();
        assertDisplayed(
                "xo-" +
                "---" +
                "---"
        );
    }

    private void assertDisplayed(String expectedMarks) {
        assertThat(display.board).isEqualTo(createBoardWithMarks(expectedMarks));
    }
}
