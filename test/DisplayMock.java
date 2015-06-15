import static org.junit.Assert.assertEquals;

class DisplayMock implements Display {
    private String showingBoard;

    @Override
    public void show(String board) {
        this.showingBoard = board;
    }

    public void shouldBeShowing(String expectedBoard) {
        assertEquals(expectedBoard, showingBoard);
    }
}
