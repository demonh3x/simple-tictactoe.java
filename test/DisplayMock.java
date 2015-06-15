import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

class DisplayMock implements Display {
    private String shownBoard;
    private boolean hasShownSomething = false;

    @Override
    public void show(String board) {
        this.shownBoard = board;
        this.hasShownSomething = true;
    }

    public void shouldHaveShown(String expectedBoard) {
        assertEquals(expectedBoard, shownBoard);
    }

    public void shouldNotHaveShownAnything() {
        assertFalse(hasShownSomething);
    }
}
