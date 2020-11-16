package frogger;
import javafx.scene.image.Image;


public class Button extends Actor{

    @Override
    public void act (long now) {

    }

    public Button (String name, int x) {
        setImage(new Image("file:src/main/resources/Button/" + name + "Button.png", 150, 150, true, true));
        setX(x);
        setY(643);
        if (name == "Start") {
            setOnMouseClicked(event -> {
                Controller.getInstance().activate("level4");
            });
        }
        else if (name == "Info") {
            setOnMouseClicked(event -> {
                Controller.getInstance().activate("info");
            });
        }
    }
}
