package frogger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends Application {
	private AnimationTimer timer;
	private Level1 level1;
	private Animal animal;
	private Music music;
	private Start start;
	private Controller controller;
	protected static String score[] = new String[10];
	private String scoreString;
	private int position;
	private Score highScore = new Score();
	private ArrayList<Digit> digitLabel = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// add start menu here

		level1 = new Level1();
	    music = new Music();
	    start = new Start();
	    Scene scene  = new Scene(start,600,800);
		controller = Controller.getInstance();
		controller.setScene(scene);

		start.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();

		animal = new Animal();
		level1.add(animal);
		controller.addScreen("level1",level1);


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
            		level1.stop();
            		// Accessing High Score List and Compare
            		highScore.readScore();
            		position = highScore.changeScore(animal.getPoints());
            		if (position != -1) {
            			highScore.renew();
					}
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		// Setting High Score List
            		scoreString = "Highest Possible Score\n";
            		for (int i = 0; i < 10; i++) {
            			scoreString += (i + 1) + ".\t" + score[i] + "\n";
					}
            		if (position == -1) {
            			scoreString += "One more game!\n";
					}
            		else {
            			scoreString += "Congratulations! You won position " + position + " in the High Score List\n";
					}
					alert.setContentText(scoreString);
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
		// clearing the existing digit
		digitLabel.forEach(new Consumer<Digit>() {
			@Override
			public void accept(Digit digit) {
				level1.remove(digit);
			}
		});
		digitLabel.clear();
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  Digit temp = new Digit(k, 30, 565 - shift, 35);
    		  // reposition the score
    		  level1.add(temp);
    		  digitLabel.add(temp);
    		  shift+=25;
    		}
    }
}
