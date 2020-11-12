package frogger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
	AnimationTimer timer;
	Background background;
	Animal animal;
	Music music;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new Background();
	    music = new Music();
	    Scene scene  = new Scene(background,600,800);
		/*
		BackgroundImage froggerback = new BackgroundImage();
		background.add(froggerback);
		background.add(new Log(2, 150, 0, 166, 0.75));
		background.add(new Log(2, 150, 220, 166, 0.75));
		background.add(new Log(2, 150, 440, 166, 0.75));

		background.add(new Log(0, 300, 0, 276, -2));
		background.add(new Log(0, 300, 400, 276, -2));

		background.add(new Log(2, 150, 50, 329, 0.75));
		background.add(new Log(2, 150, 270, 329, 0.75));
		background.add(new Log(2, 150, 490, 329, 0.75));


		background.add(new Turtle(500, 376, -1, 130, 130));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));

		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));

		background.add(new Obstacle(3, 0, 649, 1, 120, 120));
		background.add(new Obstacle(3, 300, 649, 1, 120, 120));
		background.add(new Obstacle(3, 600, 649, 1, 120, 120));

		background.add(new Obstacle(0, 100, 597, -1, 50, 50));
		background.add(new Obstacle(0, 250, 597, -1, 50, 50));
		background.add(new Obstacle(0, 400, 597, -1, 50, 50));
		background.add(new Obstacle(0, 550, 597, -1, 50, 50));
		background.add(new Obstacle(5, 0, 540, 1, 200, 200));
		background.add(new Obstacle(5, 500, 540, 1, 200, 200));
		background.add(new Obstacle(0, 500, 490, -5, 50, 50));
		// reposition the score
		background.add(new Digit(0, 30, 565, 25));
		*/

		animal = new Animal();
		background.add(animal);

		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		music.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		music.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  // reposition the score
    		  background.add(new Digit(k, 30, 565 - shift, 25));
    		  shift+=25;
    		}
    }
}
