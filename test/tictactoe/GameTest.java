package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.LiteralBoard.*;
import static tictactoe.Mark.*;

public class GameTest {
    PlayerStub x, o;
    DisplaySpy display;
    Game game;

    @Before
    public void setUp() {
        x = new PlayerStub(X);
        o = new PlayerStub(O);
        display = new DisplaySpy();
        game = new Game(Board.empty(), display, new ActivePlayer(x, o));
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

        game.doTurn();

        assertDisplayed(
                "x--" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheOPlayerInTheSecondSpace() {
        x.willPlaceMarkAt(0);
        o.willPlaceMarkAt(1);

        game.doTurn();
        game.doTurn();

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
