package frogger;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/** Play the music while game starts and stop the music while game ends */
public class Music {
    /** game background music */
    MediaPlayer mediaPlayer;

    /**
     * Instantiate a Music object
     */
    public Music(){ }

    /**
     * Play the game background music when it is called
     */
    public void playMusic() {
        String musicFile = "src/main/resources/Music/Frogger Main Song Theme (loop).mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    /**
     * Stop the game background music when it is called
     */
    public void stopMusic() {
        mediaPlayer.stop();
    }
}