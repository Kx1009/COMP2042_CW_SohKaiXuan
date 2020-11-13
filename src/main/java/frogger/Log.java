package frogger;

import javafx.scene.image.Image;

public class Log extends Actor {

	private String imageLink;
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(int type, int size, int xpos, int ypos, double s) {

		switch (type) {
			case 0:
				imageLink = "file:src/main/resources/Log/log.png";
				break;
			case 1:
				imageLink = "file:src/main/resources/Log/log2.png";
				break;
			case 2:
				imageLink = "file:src/main/resources/Log/log3.png";
				break;
		}
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
