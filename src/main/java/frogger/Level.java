package frogger;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class Level extends World {

    private Animal animal;
    private AnimationTimer timer;
    private Music music;
    private Score highScore;
    private String scoreString;
    private int position;
    private ArrayList<Digit> digitLabel = new ArrayList<>();
    private final int ENDX = 141-13;
    private final int ENDY = 96;
    private ArrayList<End> end = new ArrayList<>();
    private int level;
    private String next;
    protected final int[] row = {166,219,274,326,382,432,486,539,599,651};

    public Level(int x) {
        this.level = x;
        BackgroundImage background = new BackgroundImage(x);
        add(background);
        animal = new Animal();
        music = new Music();
        add(animal);
        // adding End
        for (int i = 0; i < 5; i++) {
            End e = new End(13+i*ENDX,ENDY);
            end.add(e);
            add(e);
        }
        add(new Digit(0, 30, 565, 35));
        highScore = new Score(level);
    }

    public void reset() {
        animal.fullReset();
        for (End e:end) {
            e.resetEnd();
        }
        setNumber(0);
        animal.resetPoints();
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                for (Actor anActor: actors) {
                    anActor.act(now);
                }
                if (animal.changeScore()) {
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    music.stopMusic();
                    stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    // Setting High Score List
                    highScore.readScore();
                    position = highScore.changeScore(animal.getPoints());
                    scoreString = "Highest Possible Score\n" + highScore.toString();
                    if (position != -1) {
                        scoreString += "Congratulations! You won position " + position + " in the High Score List\n";
                    }
                    else {
                        scoreString += "Work harder next time!";
                    }
                    alert.setContentText(scoreString);
                    alert.show();
                    alert.setOnHidden(event -> {Controller.getInstance().activate("start");});
                }
                setOnKeyPressed(event -> {if (event.getCode() == KeyCode.SPACE) {Controller.getInstance().activate("start");stop();}});
            }
        };
    }

    public Animal getAnimal() {
        return animal;
    }

    public void start() {
        music.playMusic();
        createTimer();
        timer.start();
        reset();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        // clearing the existing digit
        digitLabel.forEach(new Consumer<Digit>() {
            @Override
            public void accept(Digit digit) {
                remove(digit);
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
            add(temp);
            digitLabel.add(temp);
            shift+=25;
        }
    }
}
