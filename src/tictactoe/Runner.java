package tictactoe;

public class Runner {
    private final GameLoop gameLoop;

    public Runner(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void run() {
        gameLoop.start();
        while (gameLoop.isOngoing())
            gameLoop.doTurn();
    }
}
