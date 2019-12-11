package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import global.Themes;

public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("Multithreaded sorter - by Milica M. & Boris B.");
		setSize(new Dimension(1366, 768));
		setMinimumSize(new Dimension(1024, 576));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(getToolkit().getImage("resources/images/icon.png"));
		setBackground(null);

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Image bgImage = getToolkit().getImage(Themes.getCurrentTheme().getBackgroundImageUrl());
		Graphics2D graphics2d=(Graphics2D)g;
		graphics2d.drawImage(bgImage, 0, 0, getSize().width, getSize().height, this);
	}

}
