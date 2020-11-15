package frogger;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class Controller {

    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;
    private static Controller controller;

    private Controller() {
    }

    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    protected void activate(String name){
        main.setRoot( screenMap.get(name) );
        ((World)screenMap.get(name)).start();
    }

    protected static void setScene(Scene main) {
        controller.main = main;
    }

    protected static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

}
