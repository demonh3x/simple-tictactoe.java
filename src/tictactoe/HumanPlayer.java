package tictactoe;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Mark mark;
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayer(Mark mark, OutputStream out, InputStream in) {
        this.mark = mark;
        this.out = new PrintStream(out);
        this.in = new Scanner(in);
    }

    public Board placeMark(Board currentBoard) {
        List<Integer> availableSpaces = currentBoard.availableSpaces();

        while (true) {
            try {
                showChooseSpaceMessage(availableSpaces);
                int space = askForASpace();
                if (isAvailable(space, availableSpaces))
                    return currentBoard.withMarkAtSpace(mark, space);
            } catch (Exception invalidUserInput) {}

            showNotPossibleMessage();
        }
    }

    private boolean isAvailable(int space, List<Integer> availableSpaces) {
        return availableSpaces.contains(space);
    }

    private int askForASpace() {
        return Integer.parseInt(in.nextLine());
    }

    private void showChooseSpaceMessage(List<Integer> availableSpaces) {
        out.println("Choose space: " + availableSpaces.toString());
    }

    private void showNotPossibleMessage() {
        out.println("Sorry, that is not possible. Please try again.");
    }
}
