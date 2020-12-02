package frogger;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;


public class Animal extends Actor {

	/** image of frogger in normal state */
	private Image img1;
	/** image of frogger in jumping state */
	private Image img2;
	/** points obtained by the Animal object */
	private int points = 0;
	/** number of end reached by the Animal object */
	private int end = 0;
	/** checking if the Animal object is in the middle of animation */
	private boolean second = false;
	/** checking if the Animal object is in not moving state */
	private boolean noMove = false;
	/** x-axis movement distance in pixels which has the value of {@value #MOVEMENTX} */
	private static final double MOVEMENTY = 13.3333333*2;
	/** y-axis movement distance in pixels which has the value of {@value #MOVEMENTY} */
	private static final double MOVEMENTX = 10.666666*2;
	/** initial x-coordinate of Animal object which has the value of {@value #INITX} */
	private static final double INITX = 300;
	/** initial y-coordinate of Animal object which has the value of {@value #INITY} */
	private static final double INITY = 679.8+MOVEMENTY;
	/** points given when the Animal object reaches the End which has the value of {@value #POINT} */
	private static final double POINT = 50;
	/** size of image of the Animal object which has the value of {@value #IMGSIZE} */
	private static final int IMGSIZE = 40;
	/** checking if the Animal object meets carDeath condition */
	private boolean carDeath = false;
	/** checking if the Animal object meets waterDeath condition */
	private boolean waterDeath = false;
	/** checking if the Score needs to be updated */
	private boolean changeScore = false;
	/** counter for death animation */
	private int carD = 0;
	/** the furthest point of Animal object have reached so far */
	private double w = 800;
	/** initial water boundaries */
	private double water = 426;
	/** water platform that is intersecting */
	private WaterPlatform intersectObject;

	/**
	 * Construct an Animal object
	 * Reset the Animal object's property
	 * Call getEvent when specific key is pressed or released
	 */
	public Animal() {
		img1 = new Image("file:src/main/resources/Frogger/froggerUp.png", IMGSIZE, IMGSIZE, true, true);
		img2 = new Image("file:src/main/resources/Frogger/froggerUpJump.png", IMGSIZE, IMGSIZE, true, true);
		reset();
		setOnKeyPressed(event -> getEvent(event, second));
		setOnKeyReleased(event -> getEvent(event,true));
	}

	/**
	 * Perform when movement key is pressed
	 * @param event key event
	 * @param sec checking if the Animal object is in the middle of animation
	 */
	public void getEvent (KeyEvent event, boolean sec) {
		if (!noMove) {
			if (second) {
				setImage(img1);
			}
			else {
				setImage(img2);
			}
			switch(event.getCode()) {
				case W:
					if (getY() < w-IMGSIZE) {
						changeScore = true;
						w = getY();
						points+=10;
					}
					move(0, -MOVEMENTY);
					setRotate(0);
					break;
				case A:
					move(-MOVEMENTX, 0);
					setRotate(-90);
					break;
				case S:
					move(0, MOVEMENTY);
					setRotate(180);
					break;
				case D:
					move(MOVEMENTX, 0);
					setRotate(90);
					break;
			}
			second = !sec;
		}
	}

	/**
	 * Check if the Animal object exceeds screen
	 * Check if the Animal object meets carDeath or waterDeath
	 * Check if the Animal object is on Log, Turtle or WetTurtle
	 * Check if the Animal object reaches the End
	 * @param now time in nanoseconds
	 */
	@Override
	public void act(long now) {
		// if the frog exceeds y-axis
		if (getY()<0 || getY()>734) {
			reset();
		}
		// if the frog exceeds x-axis
		if (getX()<0) {
			setX(0);
		}
		if (getX()>600) {
			setX(600-IMGSIZE);
		}

		if (carDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			switch(carD) {
				case 1:
				case 2:
				case 3:
					setImage(new Image("file:src/main/resources/Cardeath/cardeath"+carD+".png", IMGSIZE, IMGSIZE, true, true));
					break;
				case 4:
					reset();
					if (points > POINT) {
						points -= POINT;
						changeScore = true;
					}
					break;
			}
		}
		if (waterDeath) {
			noMove = true;
			if ((now)% 11 ==0) {
				carD++;
			}
			switch(carD) {
				case 1:
				case 2:
				case 3:
				case 4:
					setImage(new Image("file:src/main/resources/Waterdeath/waterdeath"+carD+".png", IMGSIZE,IMGSIZE , true, true));
					break;
				case 5:
					reset();
					if (points>POINT) {
						points-=POINT;
						changeScore = true;
					}
					break;
			}
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(WaterPlatform.class).size() >= 1 && !noMove) {
			intersectObject = getIntersectingObjects(WaterPlatform.class).get(0);
			if (intersectObject instanceof WetTurtle && ((WetTurtle) intersectObject).isSunk()) {
				waterDeath = true;
			}
			else{
					move(intersectObject.getSpeed(), 0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=POINT;
			}
			points+=POINT;
			changeScore = true;
			w = 800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			reset();
		}
		else if (getY()<water){
			waterDeath = true;
		}
	}

	/**
	 * Set the water boundaries
	 * @param i y-coordinate of water boundaries
	 */
	public void setWater (double i) {
		water = i;
	}

	/**
	 * Set the winning condition
	 * @return True when winning condition meets
	 */
	public boolean getStop() {
		return end==5;
	}

	/**
	 * Get the points obtained by the frogger
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Reset the points obtained by the frogger
	 */
	public void resetPoints() {
		points = 0;
	}

	/**
	 * Reset changeScore to false
	 * @return initial changeScore state
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
	}

	/**
	 * Reset the Animal object's property
	 */
	public void reset() {
		noMove = false;
		carD = 0;
		setX(INITX);
		setY(INITY);
		setImage(img1);
		setRotate(0);
		waterDeath = false;
		carDeath = false;
		toFront();
	}

	/**
	 * Fully reset the game
	 * Reset the number of end reached
	 */
	public void fullReset() {
		end = 0;
		reset();
	}

}
