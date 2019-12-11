package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import global.Themes;

public class ImageBackgroundContentPane extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		Image bgImage=Toolkit.getDefaultToolkit().getImage(Themes.getCurrentTheme().getBackgroundImageUrl());
		((Graphics2D)g).drawImage(bgImage, 0, 0, getSize().width, getSize().height, this);
//		super.paintComponent(g);	//TODO: Ovo obrisati ako ne bude trebalo
	}
}
