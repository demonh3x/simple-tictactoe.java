package tictactoe;

public class GameLoopDouble implements GameLoop {
    private String methodCalls = "";
    private int remainingOngoingTurns;

    @Override
    public void start() {
        methodCalls += "start ";
    }

    @Override
    public void doTurn() {
        methodCalls += "doTurn ";
        remainingOngoingTurns--;
    }

    @Override
    public boolean isOngoing() {
        return remainingOngoingTurns > 0;
    }

    public void willBeOngoingForNTurns(int amountOfTurnsToBeOngoing) {
        this.remainingOngoingTurns = amountOfTurnsToBeOngoing;
    }

    public String getMethodCalls() {
        return methodCalls.trim();
    }
}
