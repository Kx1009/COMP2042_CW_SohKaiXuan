package frogger;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	public BackgroundImage() {
		setImage(new Image("file:src/main/resources/Background/background.png", 600, 800, false, true));
		
	}

}
