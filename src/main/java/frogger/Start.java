package frogger;

public class Start extends World {

    /**
     * @param YPOS y-coordinate of the Button which is {@value #YPOS}
     */
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
        add(new Button("Start", 50, YPOS));
        add(new Button("Info", 225, YPOS));
        add(new Button("Level", 400,YPOS));
    }

}
