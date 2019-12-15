package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.Border;

import components.ImageBackgroundContentPane;
import global.Themes;
import model.PanelSwitchingModel;

public class MainWindow extends JFrame {

	public MainWindow() {
		setTitle("Multithreaded sorter - by Milica M. & Boris B.");
		setSize(new Dimension(1366, 768));
		setMinimumSize(new Dimension(1024, 576));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(getToolkit().getImage("resources/images/icon.png"));

		setContentPane(new ImageBackgroundContentPane());
		
		//Side Menu Component
		SideMenuView sideMenu=new SideMenuView(new PanelSwitchingModel());
		sideMenu.setPreferredSize(new Dimension(250, 1000));
		sideMenu.setEdge(15);
		
		setLayout(new BorderLayout());
		add(sideMenu, BorderLayout.WEST);
		
		add(new GeneratorPanel(), BorderLayout.CENTER);
		
		setVisible(true);
	}
	

}
