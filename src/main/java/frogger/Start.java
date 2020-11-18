package frogger;

public class Start extends World {

    private final int YPOS = 643;
    @Override
    public void act(long now) {}

    public Start() {
        BackgroundImage background = new BackgroundImage(0);
        add(background);
        add(new Button("Start", 50, YPOS));
        add(new Button("Info", 225, YPOS));
        add(new Button("Level", 400,YPOS));
    }

}
