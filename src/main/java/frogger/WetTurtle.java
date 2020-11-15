package frogger;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {
		// Converting if else statement into switch case
		// Manual typecast long -> int
		switch((int)(now/900000000 % 4)){
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
	public WetTurtle(int xpos, int ypos, int s, int a) {
		turtle1 = new Image("file:src/main/resources/Turtle/TurtleAnimation1.png", a, a, true, true);
		turtle2 = new Image("file:src/main/resources/Turtle/TurtleAnimation2Wet.png", a, a, true, true);
		turtle3 = new Image("file:src/main/resources/Turtle/TurtleAnimation3Wet.png", a, a, true, true);
		turtle4 = new Image("file:src/main/resources/Turtle/TurtleAnimation4Wet.png", a, a, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
