package frogger;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Music {
    MediaPlayer mediaPlayer;

    public Music(){

    }

    public void playMusic() {
        String musicFile = "src/main/resources/Music/Frogger Main Song Theme (loop).mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void stopMusic() {
        mediaPlayer.stop();
    }
}