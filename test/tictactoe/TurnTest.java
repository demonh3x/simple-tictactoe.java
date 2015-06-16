package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TurnTest {
    public static class PlayerDummy implements Player {
        @Override
        public void placeMark(Board board) {}
    }

    Player x, o;
    Turn turn;

    @Before
    public void setUp() {
        x = new PlayerDummy();
        o = new PlayerDummy();
        turn = Turn.firstOf(x, o);
    }

    @Test
    public void theXPlayerTakesTurnFirst() {
        assertThat(turn.currentTaker()).isSameAs(x);
    }

    @Test
    public void theOPlayerTakesTurnSecond() {
        turn = turn.next();
        assertThat(turn.currentTaker()).isSameAs(o);
    }

    @Test
    public void theXPlayerTakesTurnThird() {
        turn = turn.next();
        turn = turn.next();
        assertThat(turn.currentTaker()).isSameAs(x);
    }
}
