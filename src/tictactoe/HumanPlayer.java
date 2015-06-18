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
        int selectedSpace = askForAvailableSpaceIn(currentBoard);
        return currentBoard.withMarkAtSpace(mark, selectedSpace);
    }

    private int askForAvailableSpaceIn(Board currentBoard) {
        List<Integer> availableSpaces = currentBoard.availableSpaces();
        int userSelectedSpace = askForValidSpaceDisplaying(availableSpaces);

        while (!isAvailable(userSelectedSpace, currentBoard)) {
            showNotAvailableMessage(userSelectedSpace);
            userSelectedSpace = askForValidSpaceDisplaying(availableSpaces);
        }

        return userSelectedSpace;
    }

    private boolean isAvailable(int space, Board inBoard) {
        return inBoard.availableSpaces().contains(space);
    }

    private int askForValidSpaceDisplaying(List<Integer> availableSpaces) {
        String userInput = askForUserInputDisplaying(availableSpaces);

        while (!isANumber(userInput)) {
            showNotAvailableMessage(userInput);
            userInput = askForUserInputDisplaying(availableSpaces);
        }

        return Integer.parseInt(userInput);
    }

    private boolean isANumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private String askForUserInputDisplaying(List<Integer> availableSpaces) {
        out.println("Choose space: " + availableSpaces.toString());
        return in.nextLine();
    }

    private void showNotAvailableMessage(Object userInput) {
        out.println(userInput.toString() + " is not an available space!");
    }
}
