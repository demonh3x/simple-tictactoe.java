package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TurnTest {
    Player x, o;
    Turn turn;

    @Before
    public void setUp() {
        x = new PlayerDummy();
        o = new PlayerDummy();
        turn = Turn.firstOf(x, o);
    }

    @Test
    public void theXPlayerTakesTheFirstTurn() {
        assertThat(turn.taker()).isSameAs(x);
    }

    @Test
    public void theOPlayerTakesTheSecondTurn() {
        turn = turn.next();
        assertThat(turn.taker()).isSameAs(o);
    }

    @Test
    public void theXPlayerTakesTheThirdTurn() {
        turn = turn.next();
        turn = turn.next();
        assertThat(turn.taker()).isSameAs(x);
    }
}
