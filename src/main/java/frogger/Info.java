package frogger;

import javafx.scene.input.KeyCode;

public class Info extends World{

    @Override
    public void act (long now) { }

    public Info () {
        BackgroundImage background = new BackgroundImage(9);
        this.add(background);
        setOnKeyPressed(event -> {if (event.getCode() == KeyCode.SPACE) {Controller.getInstance().activate("start");}});
    }
}
