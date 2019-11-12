package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import components.MaterialButton;
import components.MaterialTextField;
import global.Fonts;

public class GeneratorPanel extends JPanel {

	private JTextField location;
	private JTextField ammount;
	private JTextField from;
	private JTextField to;
	private JButton browse;
	private JButton confirm;
	private JButton delete;
	private JLabel number;

	public GeneratorPanel() {
		setLayout(new BorderLayout());

		JPanel west = new JPanel(new FlowLayout());
		JPanel north = new JPanel();
		BoxLayout bl = new BoxLayout(north, BoxLayout.LINE_AXIS);
		north.setLayout(bl);
		JPanel center = new JPanel(new GridLayout(1, 6));
		JPanel east = new JPanel(new FlowLayout());

		west.setBackground(Color.GREEN);
//		north.setBackground(Color.BLUE);
		center.setBackground(Color.YELLOW);
		east.setBackground(Color.ORANGE);

		setUpNorth(north);
		
		add(west, BorderLayout.WEST);
		add(north, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);

		setPreferredSize(new Dimension(600, 200));
	}

//	@Override
//	public void paint(Graphics arg0) {
//		System.out.println("Iscrtavanje");
//		((Graphics2D)arg0).clearRect(0, 0, getSize().width, getSize().height);
//		super.paint(arg0);
//	}

	private void setUpNorth(JPanel north) {
		Font labelFont = new Font(Fonts.getCurrentFontName(), Font.PLAIN, 24);
		
		JLabel locationLbl = new JLabel("Lokacija:");
		locationLbl.setFont(labelFont);
		this.location =new MaterialTextField(512);
		this.browse = new MaterialButton("...");

		
		

		north.add(locationLbl);
		north.add(location);
		north.add(browse);
	}

}
