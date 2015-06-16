package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class BoardTest {
    @Test
    public void twoEmptyBoardsAreEqual() {
        Board emptyBoardA = new Board();
        Board emptyBoardB = new Board();

        assertThat(emptyBoardA).isEqualTo(emptyBoardB);
    }

    @Test
    public void aBoardWithOneMoveIsNotEqualToAnEmptyBoard() throws Exception {
        Board boardWithOneMoveMore = new Board();
        boardWithOneMoveMore.placeMarkAtSpace(X, 0);

        Board emptyBoard = new Board();

        assertThat(boardWithOneMoveMore).isNotEqualTo(emptyBoard);
    }

    @Test
    public void twoBoardsWithTheSameMovesAreEqual() throws Exception {
        Board boardA = new Board();
        Board boardB = new Board();

        boardA.placeMarkAtSpace(X, 0);
        boardB.placeMarkAtSpace(X, 0);

        assertThat(boardA).isEqualTo(boardB);
    }
}
