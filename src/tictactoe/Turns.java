package tictactoe;

public class Turns {
    private final Player x;
    private final Player o;
    private Player next;

    public Turns(Player x, Player o) {
        this.x = x;
        this.o = o;
        this.next = x;
    }

    public Player nextPlayer() {
        Player current = next;
        next = next == x? o : x;
        return current;
    }
}
