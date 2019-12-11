package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

import global.Themes;
import settings.ColorTheme;
import view.SideMenuView;

@SuppressWarnings("serial")
public class PanelButton extends JButton {
	private Font font;
	private boolean hover = false;
	private boolean mousePressed = false;

	private String text;
	private Boolean active;

	public PanelButton(String text) {
		super(text);
		font = Themes.getCurrentTheme().getFonts().getPanelButtonFont();
		setFont(font);
		this.text = text;
		this.addMouseListener(mouseListener);
		this.active=false;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.clearRect(0, 0, getSize().width, getSize().height);
		ColorTheme theme = Themes.getCurrentTheme();
		graphics2d.setFont(font);

		Color bg = null;
		int edge = ((SideMenuView) getParent()).getEdge();
		if (hover && !mousePressed) {
			bg = theme.getThemeLighterColor();
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		} else {
			bg = theme.getThemeColor();
		}
		if (active) {
			bg = theme.getThemeDarkerColor();
			int[] xPoints = { getSize().width - edge, getSize().width, getSize().width - edge };
			int[] yPoints = { 0, getSize().height / 2, getSize().height };
			graphics2d.setColor(bg);
			graphics2d.fillPolygon(xPoints, yPoints, 3);
		}

		graphics2d.setColor(bg);
		graphics2d.fillRect(0, 0, getSize().width-edge, getSize().height);

		drawText(graphics2d, theme.getTextSecondaryColor());
	}

	private void drawText(Graphics2D graphics2d, Color color) {
		graphics2d.setColor(color);

		// Razbijanje teksta na rijeci
		ArrayList<String> lines = new ArrayList<>();
		Pattern pattern = Pattern.compile("[^\\n]+");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			lines.add(matcher.group(0));
		}

		FontMetrics fm = getFontMetrics(getFont());
		for (int i = 0; i < lines.size(); i++) {
			double temp = i + 1 - (double) (lines.size()) / 2;
			int x = getSize().width / 2 - fm.stringWidth(lines.get(i)) / 2;
			int y = getSize().height / 2 + (int) (fm.getHeight() * temp);
			graphics2d.drawString(lines.get(i), x, y);
		}
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	private MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				PanelButton.this.mousePressed = false;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				PanelButton.this.mousePressed = true;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			PanelButton.this.hover = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			PanelButton.this.hover = true;
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}
	};

}
