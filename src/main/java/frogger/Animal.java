package frogger;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;


public class Animal extends Actor {
	private Image img1;
	private Image img2;
	private int points = 0;
	private int end = 0;
	private boolean second = false;
	private boolean noMove = false;

	private static final double MOVEMENTY = 13.3333333*2;
	private static final double MOVEMENTX = 10.666666*2;
	private static final double INITX = 300;
	private static final double INITY = 679.8+MOVEMENTY;

	private final int IMGSIZE = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private ArrayList<End> inter = new ArrayList<End>();

	public Animal() {
		img1 = new Image("file:src/main/resources/Frogger/froggerUp.png", IMGSIZE, IMGSIZE, true, true);
		img2 = new Image("file:src/main/resources/Frogger/froggerUpJump.png", IMGSIZE, IMGSIZE, true, true);
		reset();

		setOnKeyPressed(event -> getEvent(event, second));
		setOnKeyReleased(event -> getEvent(event,true));
	}

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
	
	@Override
	public void act(long now) {
		// if the frog exceeds Y
		if (getY()<0 || getY()>734) {
			reset();
		}
		// if the frog exceeds X
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
			// use switch case to replace all if
			switch(carD) {
				case 1:
				case 2:
				case 3:
					setImage(new Image("file:src/main/resources/Cardeath/cardeath"+carD+".png", IMGSIZE, IMGSIZE, true, true));
					break;
				case 4:
					reset();
					if (points > 50) {
						points -= 50;
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
			// use switch case to replace all if
			switch(carD) {
				case 1:
				case 2:
				case 3:
				case 4:
					setImage(new Image("file:src/main/resources/Waterdeath/waterdeath"+carD+".png", IMGSIZE,IMGSIZE , true, true));
					break;
				case 5:
					reset();
					if (points>50) {
						points-=50;
						changeScore = true;
					}
					break;
			}
		}

		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			reset();
		}
		else if (getY()<426){
			waterDeath = true;
		}
	}

	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}

	public void reset() {
		noMove = false;
		carD = 0;
		setX(INITX);
		setY(INITY);
		setImage(img1);
		setRotate(0);
		waterDeath = false;
		carDeath = false;
	}

}
