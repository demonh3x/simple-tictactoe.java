package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TurnTest {
    Player x, o;
    Turn firstTurn;

    @Before
    public void setUp() {
        x = new PlayerDummy();
        o = new PlayerDummy();
        firstTurn = Turn.firstOf(x, o);
    }

    @Test
    public void xTakesTheFirstTurn() {
        assertThat(firstTurn.taker()).isSameAs(x);
    }

    @Test
    public void oTakesTheSecondTurn() {
        Turn secondTurn = firstTurn.next();
        assertThat(secondTurn.taker()).isSameAs(o);
    }

    @Test
    public void xTakesTheThirdTurn() {
        Turn secondTurn = firstTurn.next();
        Turn thirdTurn = secondTurn.next();
        assertThat(thirdTurn.taker()).isSameAs(x);
    }
}
