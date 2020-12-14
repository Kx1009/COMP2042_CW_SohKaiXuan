package frogger;

import javafx.scene.image.Image;

/** Create Obstacle moving on road such as Car and Truck which will cause carDeath if the frogger crashes them */
public class Obstacle extends Actor {
	/** speed of the obstacle */
	private double speed;
	/** image of the car1 object */
	private Image car1 = new Image("file:src/main/resources/Car/car1Left.png",50,50,true,true);
	/** image of the car2 object */
	private Image car2 = new Image("file:src/main/resources/Car/car2Left.png",50,50,true,true);
	/** image of the truck1 object */
	private Image truck1 = new Image("file:src/main/resources/Truck/truck1Left.png",120,120,true,true);
	/** image of the truck2 object */
	private Image truck2 = new Image("file:src/main/resources/Truck/truck2Left.png",200,200,true,true);

	/**
	 * Move the Obstacle in the scene with respective speed and direction
	 * If the Obstacle reaches the end of the scene, it will be set back to the another end
	 * @param now time in nanoseconds
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < 0-getWidth() && speed<0)
			setX(600);
	}

	/**
	 * Construct an Obstacle of car or truck by setting respective image and direction
	 * @param type type of obstacle created (0 is for car1, 1 for car2, 2 for truck1, 3 for truck2)
	 * @param xpos x-coordinate of the obstacle when it is added to the scene
	 * @param ypos y-coordinate of the obstacle when it is added to the scene
	 * @param s speed and direction of the movement of the obstacle (speed > 0 indicates moving to right and vice versa)
	 */
	public Obstacle(int type, int xpos, int ypos, int s) {
		switch(type){
			case 0:
				setImage(car1);
				break;
			case 1:
				setImage(car2);
				break;
			case 2:
				setImage(truck1);
				break;
			case 3:
				setImage(truck2);
				break;
		}
		// Rotate the image if the speed is positive
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

	/**
	 * Get the speed of the Obstacle
	 * @return the speed of the Obstacle
	 */
	public double getSpeed() {
		return speed;
	}

}
