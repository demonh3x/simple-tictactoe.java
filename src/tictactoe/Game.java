package tictactoe;

public class Game {
    private final Display display;
    private Turn currentTurn;
    private Board currentBoard;

    public Game(Display display, Turn initialTurn, Board initialBoard) {
        this.display = display;
        this.currentTurn = initialTurn;
        this.currentBoard = initialBoard;
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
        display.updateBoard(currentBoard);
    }

    private void letPlay(Player player) {
        currentBoard = player.placeMark(currentBoard);
    }

    private Player currentPlayer() {
        return currentTurn.taker();
    }

    private void advanceTurn() {
        currentTurn = currentTurn.next();
    }
}
