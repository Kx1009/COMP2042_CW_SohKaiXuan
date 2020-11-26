package frogger;

import javafx.scene.input.KeyCode;

public class Info extends World{

    /**
     * Empty act method
     * @param now time in nanoseconds
     */
    @Override
    public void act (long now) { }

    /**
     * Create an Info page
     * If "space" key is entered, back to start screen
     */
    public Info () {
        BackgroundImage background = new BackgroundImage(-1);
        add(background);
        setOnKeyPressed(event -> {if (event.getCode() == KeyCode.SPACE) {Controller.getInstance().activate("start");}});
    }
}
