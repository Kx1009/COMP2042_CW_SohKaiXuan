package frogger;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Parent class to all game level class
 * Adding Animal to the game
 * Start the game
 * Prompt alert message when game ends showing high score
 */
public abstract class Level extends World {

    /** animal object */
    private Animal animal;
    /** timer object */
    private AnimationTimer timer;
    /** music object */
    private Music music;
    /** score object */
    private Score highScore;
    /** String storing high score information in the alert message */
    private String scoreString;
    /** position of the current high score, -1 if current high score is not on the list */
    private int position;
    /** ArrayList storing Digit object in the game screen */
    private ArrayList<Digit> digitLabel = new ArrayList<>();
    /** x-coordinate of End object which will be multiplied by i where i is the position of the End object */
    private static final int ENDX = 141-13;
    /** y-coordinate of End object which is {@value #ENDY} */
    private static final int ENDY = 96;
    /** ArrayList storing End object in the game screen */
    private ArrayList<End> end = new ArrayList<>();
    /** current game level */
    private int level;
    /** array storing y-coordinate of every obstacle row in the game screen from up to down */
    protected static final int[] row = {166,219,274,326,382,432,486,539,599,651};

    /**
     * Construct a Level object with x
     * Add the respective BackgroundImage, Animal, Music, End, Digit and Score
     * @param x current game level
     */
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
        add(new Digit(0, 565, 35));
        highScore = new Score(level);
    }

    /**
     * Reset the Animal property, End property, Digit property and points obtained
     */
    public void reset() {
        animal.fullReset();
        for (End e:end) {
            e.resetEnd();
        }
        setNumber(0);
        animal.resetPoints();
    }

    /**
     * Create timer that call the act with time in nanoseconds
     * Change the score based on the points obtained
     * When the game ends (winning condition reached), stop the timer and prompt alert message with high score list
     * If "space" key is entered, back to start screen
     */
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
                    stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    // read existing high score from respective high score text file
                    highScore.readScore();
                    // check if the current score makes a position in the high score list
                    position = highScore.changeScore(animal.getPoints());
                    // set the string with the newest high score
                    scoreString = "Highest Possible Score\n" + highScore.toString();
                    // add the position statement into the string if the current score has one
                    if (position != -1) {
                        scoreString += "Congratulations! You won position " + position + " in the High Score List\n";
                    }
                    else {
                        scoreString += "Work harder next time!\n";
                    }
                    alert.setContentText(scoreString);
                    alert.show();
                    alert.setOnHidden(event -> {Controller.getInstance().activate("start");});
                }
                setOnKeyPressed(event -> {if (event.getCode() == KeyCode.SPACE) {music.stopMusic(); timer.stop(); Controller.getInstance().activate("start");}});
            }
        };
    }

    /**
     * Get the Animal object
     * @return Animal object
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Play the music
     * Create the timer
     * Start the timer
     * Reset existing Animal, End, Digit and points obtained
     */
    public void start() {
        music.playMusic();
        createTimer();
        timer.start();
        reset();
    }

    /**
     * Stop the timer
     */
    public void stop() {
        music.stopMusic();
        timer.stop();
    }

    /**
     * Set the Digit to display according to the points obtained
     * Clear the existing Digit before adding new one
     * @param n points obtained
     */
    public void setNumber(int n) {
        // clear the existing digit
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
            Digit temp = new Digit(k, 565 - shift, 35);
            // reposition the score
            add(temp);
            digitLabel.add(temp);
            shift+=25;
        }
    }
}
