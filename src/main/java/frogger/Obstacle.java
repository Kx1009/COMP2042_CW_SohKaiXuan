package frogger;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;

	private Image car;
	private Image truck1;
	private Image truck2;

	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < 0-getWidth() && speed<0)
			setX(600);
	}
	
	public Obstacle(int type, int xpos, int ypos, int s, int w) {
		car = new Image("file:src/main/resources/Car/car1Left.png",w,w,true,true);
		truck1 = new Image("file:src/main/resources/Truck/truck1Left.png",w,w,true,true);
		truck2 = new Image("file:src/main/resources/Truck/truck2Left.png",w,w,true,true);
		switch(type){
			case 0:
				setImage(car);
				break;
			case 1:
				setImage(truck1);
				break;
			case 2:
				setImage(truck2);
				break;
		}
		// rotate the image if the speed is positive
		if (s > 0) {
			setRotate(180);
		}
		else {
			setRotate(0);
		}
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
