package frogger;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = true;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End/End.png", 60, 60, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:src/main/resources/End/FrogEnd.png", 60, 60, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void resetEnd() {
		setImage(new Image("file:src/main/resources/End/End.png", 60, 60, true, true));
		activated = false;
	}


}
