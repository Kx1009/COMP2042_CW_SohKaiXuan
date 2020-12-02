package frogger;

/** Create a start screen with starting background and buttons to launch the game and read information about the game */
public class Start extends World {

    /** y-coordinate of the Button which is {@value #YPOS} */
    private final static int YPOS = 643;

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    @Override
    public void act(long now) {}

    /**
     * Create a start screen
     * Add 3 Buttons on it (Start, Info, Level)
     */
    public Start() {
        BackgroundImage background = new BackgroundImage(0);
        add(background);
        add(new Button("Start", 100, YPOS));
        add(new Button("Info",350, YPOS));
    }

}
