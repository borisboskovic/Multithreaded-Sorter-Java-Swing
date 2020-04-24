package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

import settings.ColorTheme;
import settings.Context;

@SuppressWarnings("serial")
public class ImageBackgroundContentPane extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		ColorTheme theme = Context.getContext().getColorTheme();
		Image bgImage = Toolkit.getDefaultToolkit().getImage(theme.getBackgroundImageUrl());
		((Graphics2D) g).drawImage(bgImage, 0, 0, getSize().width, getSize().height, this);
	}
}
