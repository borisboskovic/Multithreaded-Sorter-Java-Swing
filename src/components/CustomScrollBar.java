package components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

import global.Themes;
import settings.ColorTheme;

public class CustomScrollBar extends MetalScrollBarUI {

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		ColorTheme theme = Themes.getCurrentTheme();
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(theme.getThemeDarkerColor());
		graphics2d.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		ColorTheme theme = Themes.getCurrentTheme();
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(theme.getThemeLighterColor());
		graphics2d.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	private JButton createZeroButton() {
		JButton button = new JButton("zero button");
		Dimension zeroDim = new Dimension(0, 0);
		button.setPreferredSize(zeroDim);
		button.setMinimumSize(zeroDim);
		button.setMaximumSize(zeroDim);
		return button;
	}

}
