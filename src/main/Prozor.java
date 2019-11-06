package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import components.MaterialButton;
import components.PanelButton;

public class Prozor extends JFrame {

	MaterialButton button;

	public Prozor() {
		setTitle("Prozor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new FlowLayout());
		button = new MaterialButton("Button");
		panel.add(button);
		panel.add(new MaterialButton("Još jedan"));
		MaterialButton dugme = new MaterialButton(new ImageIcon("C:\\Users\\Boris\\Desktop\\gear.png"),
				new Dimension(100, 100));
		panel.add(dugme);
		
		JPanel left = new JPanel();
		left.setPreferredSize(new Dimension(250, 500));
		GridLayout leftPanelLayout = new GridLayout(0, 1);
		leftPanelLayout.setVgap(3);
				
		left.setLayout(leftPanelLayout);
		left.setBackground(Color.WHITE);
		
		left.add(new PanelButton("Generisi fajlove sa nasumiènim brojevima"));
		left.add(new PanelButton("Sortiraj na jednom tredu"));
		left.add(new PanelButton("Sortiraj više fajlova istovremeno"));
		left.add(new PanelButton("Uporedi performanse sortiranja"));
		
		
		add(panel, BorderLayout.CENTER);
		add(left, BorderLayout.WEST);
		setVisible(true);
	}

}
