package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import components.PanelButton;
import controller.SideMenuController;
import global.Themes;
import model.PanelSwitchingModel;

@SuppressWarnings("serial")
public class SideMenuView extends JPanel implements ObserverInterface {

	private int edge;

	public SideMenuView(PanelSwitchingModel model) {
		model.addObserver(this);
		this.setLayout(new GridLayout(0, 1));
		add(Box.createVerticalGlue());
		add(Box.createVerticalGlue());
		for (int i = 0; i < model.getButtons().size(); i++) {
			PanelButton button = model.getButtons().get(i);
			button.setPreferredSize(new Dimension(getSize().width, 100));
			if (i == model.getActive())
				button.setPressed(true);
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

	@Override
	public void update() {
		
		repaint();
	}

}
