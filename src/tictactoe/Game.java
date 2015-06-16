package tictactoe;

public class Game {
    private final Display display;
    private Turn currentTurn;
    private final Board board;

    public Game(Display display, Turn initialTurn, Board initialBoard) {
        this.display = display;
        this.currentTurn = initialTurn;
        this.board = initialBoard;
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
        return currentTurn.taker();
    }

    private void advanceTurn() {
        currentTurn = currentTurn.next();
    }
}
