package frogger;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private int speed;
	private String imageLink;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Obstacle(int type, int xpos, int ypos, int s, int w, int h) {
		switch(type){
			case 0:
				imageLink = "file:src/main/resources/Car/car1Left.png";
				break;
			case 1:
				imageLink = "file:src/main/resources/Car/car1Right.png";
				break;
			case 2:
				imageLink = "file:src/main/resources/Truck/truck1Left.png";
				break;
			case 3:
				imageLink = "file:src/main/resources/Truck/truck1Right.png";
				break;
			case 4:
				imageLink = "file:src/main/resources/Truck/truck2Left.png";
				break;
			case 5:
				imageLink = "file:src/main/resources/Truck/truck2Right.png";
				break;
		}
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
