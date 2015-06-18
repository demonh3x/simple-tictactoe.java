package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.TestingBoard.*;
import static tictactoe.Mark.*;

public class GameTest {
    PlayerStub x, o;
    Turn turn;
    DisplaySpy display;
    Game game;

    @Before
    public void setUp() {
        x = new PlayerStub(X);
        o = new PlayerStub(O);
        turn = Turn.firstOf(x, o);
        display = new DisplaySpy();
        game = new Game(display, turn, Board.empty());
    }

    @Test
    public void beforeStartingDoesNotDisplayTheBoard() {
        assertThat(display.hasUpdateBoardBeenCalled()).isFalse();
    }

    @Test
    public void afterStartingDisplaysAnEmptyBoard() {
        game.start();

        assertBoardContainsMarks(
                display.displayedBoard(),
                NONE, NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        );
    }

    @Test
    public void displaysTheXPlayerInTheFirstSpace() {
        x.willPlaceMarkAt(0);
        game.doTurn();

        assertBoardContainsMarks(
                display.displayedBoard(),
                X,    NONE, NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        );
    }

    @Test
    public void displaysTheOPlayerInTheSecondSpace() {
        x.willPlaceMarkAt(0);
        o.willPlaceMarkAt(1);
        doTurns(2);

        assertBoardContainsMarks(
                display.displayedBoard(),
                X,    O,    NONE,
                NONE, NONE, NONE,
                NONE, NONE, NONE
        );
    }

    @Test
    public void isOngoingBeforeAPlayerHasALine() {
        x.willPlaceMarkAt(0, 1);
        o.willPlaceMarkAt(3, 4);
        doTurns(4);

        assertThat(game.isOngoing()).isTrue();
    }

    @Test
    public void isNotOngoingWhenXPlayerHasALine() {
        x.willPlaceMarkAt(0, 1, 2);
        o.willPlaceMarkAt(3, 4);
        doTurns(5);

        assertThat(game.isOngoing()).isFalse();
    }

    private void doTurns(int amountOfTurns) {
        for (int turnIndex = 0; turnIndex < amountOfTurns; turnIndex++) {
            game.doTurn();
        }
    }
}
