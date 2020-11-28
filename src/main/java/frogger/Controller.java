package frogger;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class Controller {

    /** HashMap of screen */
    private HashMap<String, Pane> screenMap = new HashMap<>();
    /** main screen */
    private Scene main;
    /** static controller object for other class to call and use */
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
     * @param scene scene that needs to be set as main screen
     */
    protected static void setScene(Scene scene) {
        controller.main = scene;
    }

    /**
     * Get the Controller instance
     * @return controller
     */
    protected static Controller getInstance() {
        if (controller == null) {
            // create a new Controller object if the controller doesn't exist
            controller = new Controller();
        }
        return controller;
    }

}
