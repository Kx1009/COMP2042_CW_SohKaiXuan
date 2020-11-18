package frogger;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	private String imageLink;

	@Override
	public void act(long now) {

	}
	
	public BackgroundImage(int i) {
		switch (i) {
			case 0:
				imageLink = "file:src/main/resources/Background/Start.png";
				break;
			case -1:
				imageLink = "file:src/main/resources/Background/Info.png";
				break;
			case -2:
				imageLink = "file:src/main/resources/Background/Choose.png";
				break;
			default:
				imageLink = "file:src/main/resources/Background/Background" + i + ".png";
				break;
		}
		setImage(new Image(imageLink, 600, 800, false, true));
		
	}

}
