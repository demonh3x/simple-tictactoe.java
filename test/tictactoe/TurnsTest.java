package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TurnsTest {
    Player x, o;
    Turns turns;

    @Before
    public void setUp() {
        x = new Player() {
            @Override
            public void placeMark(Board board) {}
        };
        o = new Player() {
            @Override
            public void placeMark(Board board) {}
        };
        turns = new Turns(x, o);
    }

    @Test
    public void startsWithTheXPlayer() {
        Player player = turns.nextPlayer();
        assertThat(player).isSameAs(x);
    }

    @Test
    public void theSecondTurnIsForTheOPlayer() {
        turns.nextPlayer();
        Player player = turns.nextPlayer();
        assertThat(player).isSameAs(o);
    }

    @Test
    public void theThirdTurnIsForTheXPlayerAgain() {
        turns.nextPlayer();
        turns.nextPlayer();
        Player player = turns.nextPlayer();
        assertThat(player).isSameAs(x);
    }
}
