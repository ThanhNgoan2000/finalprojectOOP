package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageSetting {
private Image image;
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
public Image onSoundImage() {
	image = new ImageIcon("image/onSound.png").getImage();
	return image;
}
public Image offSoundImage() {
	image = new ImageIcon("image/offSound.png").getImage();
	return image;
}
public Image aboutImage() {
	image = new ImageIcon("image/aboutImage.png").getImage();
	return image;
}
public Image aboutButtonImage() {
	image = new ImageIcon("image/about.png").getImage();
	return image;
}
public Image undoImage() {
	image = new ImageIcon("image/undo.png").getImage();
	return image;
}
public Image cursorImage() {
	image = new ImageIcon("image/cursor.png").getImage();
	return image;
}
public Image xLabelImage() {
	image = new ImageIcon("image/xLabel.png").getImage();
	return image;
}
public Image oLabelImage() {
	image = new ImageIcon("image/oLabel.png").getImage();
	return image;
}
public Image homeIcon() {
	image = new ImageIcon("image/homeicon.png").getImage();
	return image;
}
public Image surrenderImage() {// đầu hàng
	// TODO Auto-generated method stub
	image = new ImageIcon("image/xinThua.png").getImage();
	return image;
}



}
