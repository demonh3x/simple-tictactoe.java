package tictactoe;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PlayerDummy implements Player {
    @Override
    public Board placeMark(Board board) {
        throw new NotImplementedException();
    }
}
