package tictactoe;

public class Game {
    private final Display display;
    private Turn turn;
    private final Board board;

    public Game(Display display, Turn initialTurn, Board initialBoard) {
        this.display = display;
        this.turn = initialTurn;
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
        return turn.currentTaker();
    }

    private void advanceTurn() {
        turn = turn.next();
    }
}
