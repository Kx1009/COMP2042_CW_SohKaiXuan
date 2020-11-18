package frogger;

import javafx.scene.input.KeyCode;

public class Choose extends World{

    private final int[] row = {125,125,250,250,375,375,500,500,625,625};
    private int col;
    @Override
    public void act (long now) { }

    public Choose () {
        BackgroundImage background = new BackgroundImage(-2);
        add(background);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                col = 100;
            }
            else {
                col = 350;
            }
            add(new Button("Level"+(i+1),col,row[i]));
        }
        setOnKeyPressed(event -> {if (event.getCode() == KeyCode.SPACE) {Controller.getInstance().activate("start");}});
    }
}
