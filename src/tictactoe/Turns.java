package tictactoe;

public class Turns {
    private final Player first;
    private final Player second;
    private Player next;

    public Turns(Player first, Player second) {
        this.first = first;
        this.second = second;
        this.next = first;
    }

    public Player nextPlayer() {
        Player current = next;
        advanceToNextPlayer();
        return current;
    }

    private void advanceToNextPlayer() {
        next = next == first ? second : first;
    }
}
