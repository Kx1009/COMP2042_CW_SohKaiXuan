package frogger;

import javafx.scene.image.Image;

public class Digit extends Actor{

	/** size of the image */
	private final static int dim = 30;
	/** image of the Digit */
	Image im1;

	/**
	 * Empty act method
	 * @param now time in nanoseconds
	 */
	@Override
	public void act(long now) {	}

	/**
	 * Construct a Digit object
	 * @param n the score in single digit
	 * @param x x-coordinate of the Digit
	 * @param y y-coordinate of the Digit
	 */
	public Digit(int n, int x, int y) {
		im1 = new Image("file:src/main/resources/Digit/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
	
}
