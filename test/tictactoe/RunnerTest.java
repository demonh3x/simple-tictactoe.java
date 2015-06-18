package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RunnerTest {
    @Test
    public void withTwoTurnsCallsStartOnceAndThreeTimesToDoTurn() {
        GameLoopDouble gameLoop = new GameLoopDouble();
        gameLoop.willBeOngoingForNTurns(2);
        new Runner(gameLoop).run();
        assertThat(gameLoop.getMethodCalls()).isEqualTo("start doTurn doTurn");
    }

    @Test
    public void withFiveTurnsCallsStartOnceAndThreeTimesToDoTurn() {
        GameLoopDouble gameLoop = new GameLoopDouble();
        gameLoop.willBeOngoingForNTurns(5);
        new Runner(gameLoop).run();
        assertThat(gameLoop.getMethodCalls()).isEqualTo("start doTurn doTurn doTurn doTurn doTurn");
    }
}
