package frogger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	private Level1 level1;
	private Level2 level2;
	private Level3 level3;
	private Level4 level4;
	private Level5 level5;
	private Start start;
	private Info info;
	private Choose choose;
	private Controller controller;

	public static void main(String[] args) {
		launch(args);
	}

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

		level1 = new Level1();
		controller.addScreen("Level1",level1);
		level2 = new Level2();
		controller.addScreen("Level2",level2);
		level3 = new Level3();
		controller.addScreen("Level3",level3);
		level4 = new Level4();
		controller.addScreen("Level4",level4);
		level5 = new Level5();
		controller.addScreen("Level5",level5);

	}
}
