package frogger;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	/**
	 * @param turtle1 first image of the WetTurtle animation
	 * @param turtle2 second image of the WetTurtle animation
	 * @param turtle3 third image of the WetTurtle animation
	 * @param speed the speed of the WetTurtle
	 * @param A the size of the speed which is {@value #A}
	 */
	Image turtle1 = new Image("file:src/main/resources/Turtle/TurtleAnimation1.png", A, A, true, true);
	Image turtle2 = new Image("file:src/main/resources/Turtle/TurtleAnimation2.png", A, A, true, true);
	Image turtle3 = new Image("file:src/main/resources/Turtle/TurtleAnimation3.png", A, A, true, true);
	private int speed;
	private static final int A = 130;

	/**
	 * Move the Turtle in the scene with respective speed and direction
	 * Change the state of Turtle according to the timer
	 * If the Turtle reaches the end of the scene, it will be set back to the another end
	 * @param now the timer
	 */
	@Override
	public void act(long now) {
		switch((int)(now/900000000 % 3)){
			case 0:
				setImage(turtle2);
				break;
			case 1:
				setImage(turtle1);
				break;
			case 2:
				setImage(turtle3);
				break;
		}
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < 0-getWidth() && speed<0)
			setX(600);
	}

	/**
	 * Construct a turtle object
	 * @param xpos x-coordinate of the turtle when it is added to the scene
	 * @param ypos y-coordinate of the turtle when it is added to the scene
	 * @param s speed and direction of movement of turtle (speed > 0 indicates moving to right and vice versa)
	 */
	public Turtle(int xpos, int ypos, int s) {
		setX(xpos);
		setY(ypos);
		speed = s;
		if (speed > 0) { setRotate(180); }
		setImage(turtle2);
	}

	/**
	 * Get the speed of the Turtle
	 * @return the speed of the Turtle
	 */
	public int getSpeed() {
		return speed;
	}

}
