package tictactoe;

public class Game {
    private Board board;
    private Display display;
    private Turn turn;

    public Game(Board board, Display display, Turn initialTurn) {
        this.board = board;
        this.display = display;
        this.turn = initialTurn;
    }

    public void start() {
        displayBoard();
    }

    public void doTurn() {
        letPlay(currentPlayer());
        advanceTurn();

        displayBoard();
    }

    private void displayBoard() {
        display.updateBoard(board);
    }

    private void letPlay(Player player) {
        player.placeMark(board);
    }

    private Player currentPlayer() {
        return turn.currentTaker();
    }

    private void advanceTurn() {
        turn = turn.next();
    }
}
