package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActivePlayerTest {
    PlayerSpy x, o;
    ActivePlayer activePlayer;

    @Before
    public void setUp() {
        x = new PlayerSpy();
        o = new PlayerSpy();
        activePlayer = new ActivePlayer(x, o);
    }

    @Test
    public void theXPlayerIsTheFirstActivePlayer() {
        Board board = Board.empty();

        activePlayer.placeMark(board);

        assertThat(x.lastBoardReceived).isSameAs(board);
    }

    @Test
    public void theOPlayerIsTheSecondActivePlayer() {
        activePlayer.changeToNext();
        Board board = Board.empty();

        activePlayer.placeMark(board);

        assertThat(o.lastBoardReceived).isSameAs(board);
    }

    @Test
    public void theXPlayerIsTheThirdActivePlayer() {
        activePlayer.changeToNext();
        activePlayer.changeToNext();
        Board board = Board.empty();

        activePlayer.placeMark(board);

        assertThat(x.lastBoardReceived).isSameAs(board);
    }
}
