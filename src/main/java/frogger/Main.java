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
	AnimationTimer timer;
	Background background;
	Animal animal;
	Music music;
	protected static String score[] = new String[10];
	private String scorestring;
	Score highscore = new Score();
	private int position;
	ArrayList<Digit> digitLabel = new ArrayList<>();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {


		background = new Background();
	    music = new Music();
	    Scene scene  = new Scene(background,600,800);

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
            		// Accessing High Score List and Compare
            		highscore.readScore();
            		position = highscore.changeScore(animal.getPoints());
            		if (position != -1) {
            			highscore.renew();
					}
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		// Setting High Score List
            		scorestring = "Highest Possible Score\n";
            		for (int i = 0; i < 10; i++) {
            			scorestring += (i + 1) + ".\t" + score[i] + "\n";
					}
            		if (position == -1) {
            			scorestring += "One more game!\n";
					}
            		else {
            			scorestring += "Congratulations! You won position " + position + " in the High Score List\n";
					}
					alert.setContentText(scorestring);
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
				background.remove(digit);
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
    		  background.add(temp);
    		  digitLabel.add(temp);
    		  shift+=25;
    		}
    }
}
