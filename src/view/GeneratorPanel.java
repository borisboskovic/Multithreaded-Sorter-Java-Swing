package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.GeneratorModel;

public class GeneratorPanel extends JPanel {

	public GeneratorPanel() {
		setBackground(Color.GREEN);
		BoxLayout bLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(bLayout);

		GeneratorSection section = new GeneratorSection(new GeneratorModel());
//		section.setMaximumSize(new Dimension(2000, 200));
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		panel.setMaximumSize(new Dimension(2000,250));
		panel.setLayout(new GridLayout(1,1));
		panel.setOpaque(false);
		panel.add(section);
		add(panel);
		
//		section.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
//		Border border = new BevelBorder(5);
//		section.setBorder(border);
//		add(section);
//		add(new GeneratorSection());
//		add(new GeneratorSection());
//		add(new GeneratorSection());
		setOpaque(false);
	}

}
