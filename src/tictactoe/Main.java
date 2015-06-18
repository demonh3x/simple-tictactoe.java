package tictactoe;

import static tictactoe.Mark.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Missing player types (2) arguments (human/computer)!");
            return;
        }

        String playerXType = args[0];
        String playerOType = args[1];

        PlayerFactory factory = new PlayerFactory(System.in, System.out);
        Player x = factory.create(playerXType, X);
        Player o = factory.create(playerOType, O);

        Game game = new Game(new CliDisplay(System.out), Turn.firstOf(x, o), Board.empty());

        new Runner(game).run();
    }
}
