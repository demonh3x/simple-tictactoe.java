class DisplaySpy implements Display {
    public String shownBoard;
    public boolean hasShownSomething = false;

    @Override
    public void show(String board) {
        this.shownBoard = board;
        this.hasShownSomething = true;
    }
}
