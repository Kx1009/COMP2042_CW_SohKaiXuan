package frogger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  The main class that launches the application
 *  Create start screen, info screen, choose level screen and each game level object and add them into the Controller screenMap
 */
public class Main extends Application {
	/** start screen object */
	private Start start;
	/** controller object */
	private Controller controller;

	/**
	 * Main method that launches the application
	 * @param args command line argument
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Set the main scene to start screen
	 * Add info, choose level and every level into screen with respective name
	 * @param primaryStage application interface
	 */
	@Override
	public void start(Stage primaryStage){

	    start = new Start();
	    // create a scene with start screen and set it to the main screen
	    Scene scene  = new Scene(start,600,800);
		controller = Controller.getInstance();
		controller.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
		// add start screen, info screen and choose level screen
		controller.addScreen("start",start);
		controller.addScreen("info",new Info());
		controller.addScreen("level",new Choose());
		// add each respective game level screen from 1 to 10
		controller.addScreen("Level1",new LevelBuilder().getLevel(1));
		controller.addScreen("Level2",new LevelBuilder().getLevel(2));
		controller.addScreen("Level3",new LevelBuilder().getLevel(3));
		controller.addScreen("Level4",new LevelBuilder().getLevel(4));
		controller.addScreen("Level5",new LevelBuilder().getLevel(5));
		controller.addScreen("Level6",new LevelBuilder().getLevel(6));
		controller.addScreen("Level7",new LevelBuilder().getLevel(7));
		controller.addScreen("Level8",new LevelBuilder().getLevel(8));
		controller.addScreen("Level9",new LevelBuilder().getLevel(9));
		controller.addScreen("Level10",new LevelBuilder().getLevel(10));
	}
}
