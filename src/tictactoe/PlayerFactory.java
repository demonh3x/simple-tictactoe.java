package tictactoe;

import java.io.InputStream;
import java.io.OutputStream;

public class PlayerFactory {
    private final InputStream in;
    private final OutputStream out;

    public PlayerFactory(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public Player create(String type, Mark mark) {
        switch (type) {
            case "human":
                return new HumanPlayer(mark, out, in);
            case "computer":
                return new ComputerPlayer(mark);
            default:
                throw new IllegalArgumentException(type);
        }
    }
}
