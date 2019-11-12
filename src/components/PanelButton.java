package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;

import global.Fonts;
import global.Themes;
import settings.ColorTheme;

@SuppressWarnings("serial")
public class PanelButton extends JButton {
	private Font font;
	private boolean hover = false;
	private boolean mousePressed = false;
	private boolean isFocused = false;

	private String text;

	public PanelButton(String text) {
		super(text);
		font = new Font(Fonts.getCurrentFontName(), Font.PLAIN, 24);
		setFont(font);
		this.text = text;
		this.addMouseListener(mouseListener);
		this.addFocusListener(focusListener);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ColorTheme theme = Themes.getCurrentTheme();
		graphics2d.setFont(font);

		if (hover && !mousePressed) {
			graphics2d.setColor(getParent().getBackground());
			graphics2d.fillRect(0, 0, getSize().width, getSize().height);
			graphics2d.setStroke(new BasicStroke(4));
			graphics2d.setColor(theme.getThemeColor());

			graphics2d.drawLine(getSize().width - 3, 0, getSize().width - 3, getSize().height);
			drawText(graphics2d, theme.getThemeColor());
			return;
		}

		if (mousePressed) {

		}
		
		graphics2d.setColor(theme.getThemeColor());
		graphics2d.fillRect(0, 0, getSize().width, getSize().height);
		drawText(graphics2d, theme.getSecondaryTextColor());

		if (isFocused) {
			graphics2d.setColor(theme.getDangerColor());
			graphics2d.fillOval(getSize().width - 12, getSize().height - 12, 10, 10);
		}
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

	private FocusListener focusListener = new FocusListener() {

		@Override
		public void focusLost(FocusEvent e) {
			PanelButton.this.isFocused = false;
		}

		@Override
		public void focusGained(FocusEvent e) {
			PanelButton.this.isFocused = true;
		}
	};

}
