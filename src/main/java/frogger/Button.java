package frogger;
import javafx.scene.image.Image;


public class Button extends Actor{

    @Override
    public void act (long now) {

    }

    public Button (String name, int x, int y) {
        setImage(new Image("file:src/main/resources/Button/" + name + ".png", 150, 100, true, true));
        setX(x);
        setY(y);
        switch (name) {
            case "Start":
                setOnMouseClicked(event -> { Controller.getInstance().activate("level1"); });
                break;
            case "Info":
                setOnMouseClicked(event -> { Controller.getInstance().activate("info"); });
                break;
            case "Level":
                setOnMouseClicked(event -> { Controller.getInstance().activate("level"); });
                break;
            default:
                setOnMouseClicked(event -> { Controller.getInstance().activate(name); });
                break;
        }
    }
}
