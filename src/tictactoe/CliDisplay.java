package tictactoe;

import java.io.OutputStream;
import java.io.PrintStream;

public class CliDisplay implements Display {
    private final PrintStream out;

    public CliDisplay(OutputStream out) {
        this.out = new PrintStream(out);
    }

    @Override
    public void updateBoard(Board board) {
        printBoard(board);
        printResult(board);
    }

    private void printBoard(Board board) {
        out.println(representationOf(board));
    }

    private void printResult(Board board) {
        if (board.isFinished())
            out.print(resultTextFor(board));
    }

    private String representationOf(Board board) {
        String representation = "";

        for (Mark mark : board.marks())
            representation += mark.getSymbol();

        return splitRows(representation);
    }

    private String splitRows(String representation) {
        representation = representation.substring(0, 3) + "\n" +
                representation.substring(3, 6) + "\n" +
                representation.substring(6) + "\n";

        return representation;
    }

    private String resultTextFor(Board board) {
        return board.getWinner().getResultMessage() + "\n";
    }
}
