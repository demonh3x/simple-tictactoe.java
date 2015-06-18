package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class PlayerFactoryTest {
    PlayerFactory factory = new PlayerFactory(System.in, System.out);

    @Test
    public void createsAHumanPlayer() {
        Player player = factory.create("human", X);
        assertThat(player).isInstanceOf(HumanPlayer.class);
    }

    @Test
    public void createsAComputerPlayer() {
        Player player = factory.create("computer", O);
        assertThat(player).isInstanceOf(ComputerPlayer.class);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalidTypeThrowsIllegalArgument() {
        factory.create("invalidType", O);
    }
}
