package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageSetting {
private Image image;
public Image backgroundImage() {
    image = new ImageIcon("image/background.png").getImage();
	return image;
}
public Image gameImage() {
    image = new ImageIcon("image/game.png").getImage();
	return image;
}
public Image labelXImage() {
	image = new ImageIcon("image/x.png").getImage();
	return image;
}
public Image labelOImage() {
	image = new ImageIcon("image/o.png").getImage();
	return image;
}
public Image startButtonImage() {
	image = new ImageIcon("image/start.png").getImage();
	return image;
}
public Image playButtonImage() {
	image = new ImageIcon("image/play.png").getImage();
	return image;
}
public Image muteButtonImage() {
	image = new ImageIcon("image/onSound.png").getImage();
	return image;
}
public Image homeButtonImage() {
	image = new ImageIcon("image/offSound.png").getImage();
	return image;
}


}
