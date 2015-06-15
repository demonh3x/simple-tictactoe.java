class Board {
    private static final String NO_MARKS = "---------";

    private String marks;
    private String currentMark;

    public Board() {
        this.marks = NO_MARKS;
        this.currentMark = "x";
    }

    public void placeMarkAt(int space) {
        String marksBeforeTheSpace = marks.substring(0, space);
        String marksAfterTheSpace = marks.substring(space + 1);
        marks = marksBeforeTheSpace + currentMark + marksAfterTheSpace;
        currentMark = "o";
    }

    public String marks() {
        return marks;
    }
}
