package frogger;

import javafx.scene.image.Image;

public class End extends Actor{
	/** state of the End (with Frogger or without Frogger) */
	boolean activated = true;

	/**
	 * Empty act method
	 * @param now time in nanoseconds
	 */
	@Override
	public void act(long now) {	}

	/**
	 * Constuct an End object with unactivated End image
	 * @param x x-coordinate of the End object
	 * @param y y-coordinate of the End object
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End/End.png", 60, 60, true, true));
	}

	/**
	 * Set the state of End object to activated
	 * Replace the image with activated End image
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/End/FrogEnd.png", 60, 60, true, true));
		activated = true;
	}

	/**
	 * Check if the End object
	 * @return state of the End object
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Reset the End object with unactivated End image
	 * Set the state of the End object to unactivated
	 */
	public void resetEnd() {
		setImage(new Image("file:src/main/resources/End/End.png", 60, 60, true, true));
		activated = false;
	}
}
