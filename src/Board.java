class Board {
    private static final String NO_MARKS = "---------";

    private String placedMarks;
    private String nextMark;

    public Board() {
        this(NO_MARKS, "x");
    }

    public Board(String placedMarks, String nextMark) {
        this.placedMarks = placedMarks;
        this.nextMark = nextMark;
    }

    public String placedMarks() {
        return placedMarks;
    }

    public void placeNextMarkAt(int space) {
        placeMarkAt(space);
        advanceMark();
    }

    private void placeMarkAt(int space) {
        String marksBeforeTheSpace = placedMarks.substring(0, space);
        String marksAfterTheSpace = placedMarks.substring(space + 1);
        placedMarks = marksBeforeTheSpace + nextMark + marksAfterTheSpace;
    }

    private void advanceMark() {
        nextMark = "o";
    }
}
