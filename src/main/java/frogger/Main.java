package frogger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	/**
	 * @param start start screen object
	 * @param info info screen object
	 * @param choose choose level screen object
	 * @param controller controller object
	 */
	private Start start;
	private Info info;
	private Choose choose;
	private Controller controller;

	/**
	 * Main method that launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Set the main scene to start screen
	 * Add info, choose level and every level into screen with respective name
	 * @param primaryStage ********************************
	 * @throws Exception ***********************
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

	    start = new Start();
	    info = new Info();
	    choose = new Choose();
	    Scene scene  = new Scene(start,600,800);
		controller = Controller.getInstance();
		controller.setScene(scene);
		controller.addScreen("start",start);
		controller.addScreen("info",info);
		controller.addScreen("level",choose);

		primaryStage.setScene(scene);
		primaryStage.show();

		controller.addScreen("Level1",new Level1());
		controller.addScreen("Level2",new Level2());
		controller.addScreen("Level3",new Level3());
		controller.addScreen("Level4",new Level4());
		controller.addScreen("Level5",new Level5());
		controller.addScreen("Level6",new Level6());
		controller.addScreen("Level7",new Level7());
		controller.addScreen("Level8",new Level8());
		controller.addScreen("Level9",new Level9());
		controller.addScreen("Level10",new Level10());
	}
}
