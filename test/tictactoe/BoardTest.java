package tictactoe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        boardWithOneMoveMore.placeMarkAt('x', 0);

        Board emptyBoard = new Board();

        assertThat(boardWithOneMoveMore).isNotEqualTo(emptyBoard);
    }

    @Test
    public void twoBoardsWithTheSameMovesAreEqual() throws Exception {
        Board boardA = new Board();
        Board boardB = new Board();

        boardA.placeMarkAt('x', 0);
        boardB.placeMarkAt('x', 0);

        assertThat(boardA).isEqualTo(boardB);
    }
}
