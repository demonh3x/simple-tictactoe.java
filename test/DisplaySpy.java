class DisplaySpy implements Display {
    public String board;
    public boolean isDisplayingABoard = false;

    @Override
    public void updateBoard(String board) {
        this.board = board;
        this.isDisplayingABoard = true;
    }
}
