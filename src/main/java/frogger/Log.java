package frogger;

import javafx.scene.image.Image;

public class Log extends Actor {

	private String imageLink;
	private double speed;
	private int size;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(int type, int xpos, int ypos, double s) {

		switch (type) {
			case 0:
				imageLink = "file:src/main/resources/Log/log.png";
				size = 300;
				break;
			case 1:
				imageLink = "file:src/main/resources/Log/log2.png";
				size = 200;
				break;
			case 2:
				imageLink = "file:src/main/resources/Log/log3.png";
				size = 150;
				break;
		}
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		if (speed > 0) {
			setRotate(180);
		}
		
	}
	public boolean getLeft() {
		return speed < 0;
	}

	public double getSpeed() {
		return speed;
	}
}
