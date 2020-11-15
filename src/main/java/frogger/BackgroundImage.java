package frogger;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	private String imageLink;

	@Override
	public void act(long now) {

	}
	
	public BackgroundImage(int i) {
		if (i == 0) {
			imageLink = "file:src/main/resources/Background/Main.png";
		}
		else {
			imageLink = "file:src/main/resources/Background/Background.png";
		}
		setImage(new Image(imageLink, 600, 800, false, true));
		
	}

}
