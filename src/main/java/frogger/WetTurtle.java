package frogger;
import javafx.scene.image.Image;
import java.util.Random;

/** Create a WetTurtle with animations of swimming and sinking on the water as platform for frogger */
public class WetTurtle extends WaterPlatform {

	/** first image file of the WetTurtle animation */
	Image turtle1 = new Image("file:src/main/resources/Turtle/TurtleAnimation1.png", A, A, true, true);
	/** second image file of the WetTurtle animation */
	Image turtle2 = new Image("file:src/main/resources/Turtle/TurtleAnimation2Wet.png", A, A, true, true);
	/** third image file of the WetTurtle animation */
	Image turtle3 = new Image("file:src/main/resources/Turtle/TurtleAnimation3Wet.png", A, A, true, true);
	/** fourth image file of the WetTurtle animation */
	Image turtle4 = new Image("file:src/main/resources/Turtle/TurtleAnimation4Wet.png", A, A, true, true);
	/** speed of the WetTurtle */
	private double speed;
	/** size of the speed which is {@value #A} */
	private static final int A = 130;
	/** state of the WetTurtle (floating or sunk) */
	boolean sunk = false;
	/** initiate an instance of Random class */
	Random rand =  new Random();
	/** a counter to specify each wetTurtle object timer */
	private int random;

	/**
	 * Move the WetTurtle in the scene with respective speed and direction
	 * Change the state of WetTurtle according to the timer
	 * If the WetTurtle reaches the end of the scene, it will be set back to the another end
	 * @param now time in nanoseconds
	 */
	@Override
	public void act(long now) {
		switch((int)((now/900000000 + random) % 4)){
			case 0:
				setImage(turtle2);
				sunk = false;
				break;
			case 1:
				setImage(turtle1);
				sunk = false;
				break;
			case 2:
				setImage(turtle3);
				sunk = false;
				break;
			case 3:
				setImage(turtle4);
				sunk = true;
				break;
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < 0-getWidth() && speed<0)
			setX(600);
	}

	/**
	 * Construct a WetTurtle object by setting respective image and direction
	 * @param xpos x-coordinate of the WetTurtle when it is added to the scene
	 * @param ypos y-coordinate of the WetTurtle when it is added to the scene
	 * @param s speed and direction of movement of WetTurtle (speed > 0 indicates moving to right and vice versa)
	 */
	public WetTurtle(int xpos, int ypos, int s) {
		super(xpos, ypos, s);
		random = rand.nextInt(3);
		speed = s;
		if (speed > 0) { setRotate(180); }
		setImage(turtle2);
	}

	/**
	 * Check the current state of the WetTurtle
	 * @return the current state of the WetTurtle (floating or sunk)
	 */
	public boolean isSunk() {
		return sunk;
	}

}
