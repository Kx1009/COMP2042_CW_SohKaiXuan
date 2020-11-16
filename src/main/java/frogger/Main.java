package frogger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends Application {
	private Level1 level1;
	private Start start;
	private Info info;
	private Controller controller;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	    start = new Start();
	    info = new Info();
	    Scene scene  = new Scene(start,600,800);
		controller = Controller.getInstance();
		controller.setScene(scene);
		controller.addScreen("start",start);
		controller.addScreen("info",info);

		//start.start();
		primaryStage.setScene(scene);
		primaryStage.show();

		level1 = new Level1();
		controller.addScreen("level1",level1);

	}
}
