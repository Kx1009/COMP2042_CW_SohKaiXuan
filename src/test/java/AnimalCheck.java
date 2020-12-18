import frogger.Animal;
import javafx.embed.swing.JFXPanel;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;


import static org.junit.jupiter.api.Assertions.*;


public class AnimalCheck extends ApplicationTest {

    private JFXPanel panel = new JFXPanel();
    private static final double INITX = 300;
    private static final double INITY = 679.8+13.3333333*2;
    Animal animal = new Animal();

    @Test
    public void checkPosition() {
        animal.setX(10);
        animal.setY(10);
        animal.reset();
        assertEquals(INITX,animal.getX());
        assertEquals(INITY,animal.getY());
    }

    @Test
    public void checkEnd() {
        animal.fullReset();
        assertEquals(0,animal.getEnd());
    }

    @Test
    public void checkDeath() {
        animal.reset();
        assertFalse(animal.getDeath());
    }

    @Test
    public void checkPoint() {
        animal.resetPoints();
        assertEquals(0,animal.getPoints());
    }
}