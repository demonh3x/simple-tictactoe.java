public class Game {
    private final Display display;

    public Game(Display display) {
        this.display = display;
    }

    public void start() {
        display.show("---------");
    }
}
