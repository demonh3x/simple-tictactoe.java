package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.BoardAssertions.*;
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
        game = new Game(display, Turn.firstOf(x, o), Board.empty());
    }

    @Test
    public void beforeStartingDoesNotDisplayTheBoard() {
        assertThat(display.isDisplayingABoard).isFalse();
    }

    @Test
    public void afterStartingDisplaysAnEmptyBoard() {
        game.start();

        assertBoardContainsMarks(
                display.board,
                "---" +
                "---" +
                "---"
        );
    }

    @Test
    public void displaysTheXPlayerInTheFirstSpace() {
        x.willPlaceMarkAt(0);

        game.doTurn();

        assertBoardContainsMarks(
                display.board,
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

        assertBoardContainsMarks(
                display.board,
                "xo-" +
                "---" +
                "---"
        );
    }
}
