package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.Mark.*;

public class BoardTest {
    @Test
    public void twoEmptyBoardsAreEqual() {
        Board emptyBoardA = Board.empty();
        Board emptyBoardB = Board.empty();

        assertThat(emptyBoardA).isEqualTo(emptyBoardB);
    }

    @Test
    public void aBoardWithOneMarkIsNotEqualToAnEmptyBoard() throws Exception {
        Board boardWithOneMoveMore = Board.empty();
        boardWithOneMoveMore.placeMarkAtSpace(X, 0);

        Board emptyBoard = Board.empty();

        assertThat(boardWithOneMoveMore).isNotEqualTo(emptyBoard);
    }

    @Test
    public void twoBoardsWithTheSameMarkAtTheSameSpaceAreEqual() throws Exception {
        Board boardA = Board.empty();
        Board boardB = Board.empty();

        boardA.placeMarkAtSpace(X, 0);
        boardB.placeMarkAtSpace(X, 0);

        assertThat(boardA).isEqualTo(boardB);
    }
}
