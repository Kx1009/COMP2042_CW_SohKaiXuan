package frogger;

import javafx.scene.image.Image;

public class Log extends WaterPlatform {

	/** image file for the log, log2 and log3 */
	private String imageLink;
	/** speed of the Log */
	private double speed;
	/** size of the Log */
	private int size;

	/**
	 * Move the Log in the Scene with respective speed and direction
	 * If the Log reaches the end of the scene, it will be set back to the another end
	 * @param now time in nanoseconds
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/**
	 * Construct a Log object
	 * @param type type of the Log
	 * @param xpos x-coordinate of the Log when it is added to the scene
	 * @param ypos y-coordinate of the Log when it is added to the scene
	 * @param s speed and direction of movement of Log (speed > 0 indicates moving to right and vice versa)
	 */
	public Log(int type, int xpos, int ypos, double s) {
		super(xpos, ypos, s);
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
		speed = s;
		if (speed > 0) {
			setRotate(180);
		}
	}

}
