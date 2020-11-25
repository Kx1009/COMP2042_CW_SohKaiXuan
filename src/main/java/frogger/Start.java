package frogger;

public class Start extends World {

    /**
     * @param YPOS y-coordinate of the Button which is {@value #YPOS}
     */
    private final static int YPOS = 643;

    /**
     * @param now the timer
     */
    @Override
    public void act(long now) {}

    /**
     * Create the start screen and add 3 Buttons on it
     */
    public Start() {
        BackgroundImage background = new BackgroundImage(0);
        add(background);
        add(new Button("Start", 50, YPOS));
        add(new Button("Info", 225, YPOS));
        add(new Button("Level", 400,YPOS));
    }

}
