package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.JPanel;

import components.PanelButton;
import controller.SideMenuController;
import global.Themes;
import model.SideMenuModel;

public class SideMenuView extends JPanel {

	private SideMenuModel model;
	private int edge;

	public SideMenuView(SideMenuModel model) {
		this.model = model;
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
		setOpaque(false);
		new SideMenuController(model, this);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		g.setColor(Themes.getCurrentTheme().getThemeColor());
		graphics2d.fillRect(0, 0, getSize().width - edge, getSize().height);
		super.paint(g);
	}

	public int getEdge() {
		return edge;
	}

	public void setEdge(int edge) {
		this.edge = edge;
	}

}
