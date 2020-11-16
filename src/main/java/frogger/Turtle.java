package frogger;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private int speed;
	@Override
	public void act(long now) {
		// Converting if else statement into switch case
		// Manual typecast long -> int
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
	public Turtle(int xpos, int ypos, int s, int a) {
		turtle1 = new Image("file:src/main/resources/Turtle/TurtleAnimation1.png", a, a, true, true);
		turtle2 = new Image("file:src/main/resources/Turtle/TurtleAnimation2.png", a, a, true, true);
		turtle3 = new Image("file:src/main/resources/Turtle/TurtleAnimation3.png", a, a, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		if (speed > 0) { setRotate(180); }
		setImage(turtle2);
	}

	public int getSpeed() {
		return speed;
	}

}
