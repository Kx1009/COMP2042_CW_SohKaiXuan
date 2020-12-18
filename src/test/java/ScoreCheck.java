import frogger.Score;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCheck extends ApplicationTest{

    private JFXPanel panel = new JFXPanel();

    @Test
    public void checkNumberOfHighScore() {
        Score score = new Score(1);
        score.readScore();
        assertEquals(3,score.getSize());
        // Save the existing high score
        ArrayList<Integer> scorelist = score.getHighScore();
        // Test with the new high score
        score.changeScore(1000);
        // Check if the size of ArrayList remains 3
        assertEquals(3,score.getSize());
        // Replace the modified high score list with the original high score
        score.resetHighScore();
        scorelist = new ArrayList<>(scorelist.subList(1,4));
        for (Integer num:scorelist) {
            score.changeScore(num);
        }
    }
}
