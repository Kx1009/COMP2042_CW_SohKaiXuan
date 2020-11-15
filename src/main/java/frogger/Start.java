package frogger;

public class Start extends World {

    @Override
    public void act(long now) {}

    public Start() {
        BackgroundImage background = new BackgroundImage(0);
        this.add(background);
        Button start = new Button("Start", 100);
        Button info = new Button("Info", 350);
        this.add(start);
        this.add(info);
    }

}
