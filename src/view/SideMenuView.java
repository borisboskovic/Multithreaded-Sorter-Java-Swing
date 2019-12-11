package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import components.PanelButton;
import global.Themes;
import model.SideMenuModel;

public class SideMenuView extends JPanel {

	private SideMenuModel model;
	private int edge;

	public SideMenuView(SideMenuModel model) {
		this.model = model;
		setBackground(Themes.getCurrentTheme().getThemeColor());
		this.setLayout(new GridLayout(0, 1));
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		for (PanelButton button : model.getButtons()) {
			button.setPreferredSize(new Dimension(getSize().width, 100));
			add(button);
		}
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		edge = 0;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.clearRect(getSize().width - edge, 0, getSize().width - edge, getSize().height);
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}

}
