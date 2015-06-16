package tictactoe;

public class Turn {
    public static Turn firstOf(Player first, Player second) {
        return new Turn(first, second, first);
    }

    private final Player currentTaker;
    private final Player first;
    private final Player second;

    private Turn(Player first, Player second, Player currentTaker) {
        this.first = first;
        this.second = second;
        this.currentTaker = currentTaker;
    }

    public Player taker() {
        return currentTaker;
    }

    public Turn next() {
        return new Turn(first, second, nextTaker());
    }

    private Player nextTaker() {
        return currentTaker == first ? second : first;
    }
}
