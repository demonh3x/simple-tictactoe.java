package tictactoe;

public class ActivePlayer {
    private final Player first;
    private final Player second;
    private Player active;

    public ActivePlayer(Player first, Player second) {
        this.first = first;
        this.second = second;
        this.active = first;
    }

    public void changeToNext() {
        active = active == first ? second : first;
    }

    public void placeMark(Board board) {
        active.placeMark(board);
    }
}
