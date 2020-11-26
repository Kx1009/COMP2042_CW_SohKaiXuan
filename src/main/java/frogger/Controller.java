package frogger;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class Controller {

    /**
     * @param screenMap HashMap of screen
     * @param main main screen
     * @param controller controller for other class to call
     */
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;
    private static Controller controller;

    /**
     * Construct a Controller object
     */
    private Controller() { }

    /**
     * Add the screen with respective name
     * @param name name of the screen should be saved with
     * @param pane the screen object
     */
    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    /**
     * Remove the screen with respective name
     * @param name name of the screen should be deleted
     */
    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    /**
     * Activate the screen with respective name
     * @param name name of the screen should be activated
     */
    protected void activate(String name){
        main.setRoot( screenMap.get(name) );
        ((World)screenMap.get(name)).start();
    }

    /**
     * Set scene with the main screen
     * @param main ********************
     */
    protected static void setScene(Scene main) {
        controller.main = main;
    }

    /**
     * Get the Controller instance
     * @return controller object
     */
    protected static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

}
