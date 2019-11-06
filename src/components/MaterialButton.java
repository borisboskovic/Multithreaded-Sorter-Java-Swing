package components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import global.ActiveTheme;
import settings.ColorTheme;

//TODO: Primijeniti boje iz teme
@SuppressWarnings("serial")
public class MaterialButton extends JButton {
	private static final int PRIMARY_BUTTON = 1;
	private static final int SECONDARY_BUTTON = 2;
	private static final int OPTIONAL_BUTTON = 3;

	private int buttonType;
	private Color primaryColor = new Color(32, 135, 255);
	private Color hoverColor = new Color(255, 50, 50);
	private Color focusColor = new Color(255, 0, 0);
	private Color textColor = new Color(255, 255, 255);
	private Color textColorHover = new Color(255, 255, 255);

	private Font font = new Font("MS UI Gothic", Font.BOLD, 24);

	private boolean hover = false;
	private boolean mousePressed = false;
	private boolean isFocused = false;

	private String text = null;
	private Icon icon = null;

	public MaterialButton(String text) {
		super(text);
		super.setFont(font);
		this.text = text;
		buttonType = 1;
		this.addMouseListener(mouseListener);
		this.addFocusListener(focusListener);
	}

	public MaterialButton(String text, int buttonType) {
		super(text);
		super.setFont(font);
		this.text = text;
		this.buttonType = buttonType;
		this.addMouseListener(mouseListener);
		this.addFocusListener(focusListener);
	}

	public MaterialButton(Icon icon, Dimension preferedSize) {
		super(icon);
		this.icon = icon;
		this.addMouseListener(mouseListener);
		this.addFocusListener(focusListener);
		setPreferredSize(preferedSize);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setFont(font);
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setColor(this.getParent().getBackground());
		Dimension dimensions = this.getPreferredSize();
		graphics2d.fillRect(0, 0, dimensions.width, dimensions.height);
		int borderRadius = (dimensions.width > dimensions.height) ? dimensions.height / 4 : dimensions.width / 4;

		ColorTheme th =ActiveTheme.getInstance();
		
		if (icon != null) {
			Image image = ((ImageIcon) icon).getImage();
			int st = borderRadius / 5; // Stroke thickness
			graphics2d.setStroke(new BasicStroke(st));

			if (hover && !mousePressed) {
				graphics2d.setColor(th.getSeparatorColor());
				graphics2d.drawOval(st / 2, st / 2, dimensions.width - st, dimensions.height - st);
			}

			if (mousePressed) {
				graphics2d.setColor(th.getSeparatorColor());
				graphics2d.drawOval(st, st, dimensions.width - st * 2, dimensions.height - st * 2);
			}

			graphics2d.drawImage(image, borderRadius, borderRadius, dimensions.width - 2 * borderRadius,
					dimensions.height - 2 * borderRadius, this);

			if (isFocused) {
				graphics2d.setColor(th.getDangerColor());
				graphics2d.fillOval(dimensions.width - borderRadius, dimensions.height - borderRadius, 10, 10);
			}

		} else if (text != null) {
			if (hover && !mousePressed) {
				graphics2d.setColor(hoverColor);
				graphics2d.fillRoundRect(0, 0, dimensions.width, dimensions.height, borderRadius, borderRadius);
				graphics2d.setColor(textColorHover);
				Point p = getTextPosition(font);
				graphics2d.drawString(text, p.x, p.y);
				return;
			}

			if (mousePressed) {
				graphics2d.setColor(hoverColor);
				graphics2d.fillRoundRect(2, 2, dimensions.width - 4, dimensions.height - 4, borderRadius, borderRadius);
				graphics2d.setColor(textColorHover);
				Point p = getTextPosition(font);
				graphics2d.drawString(text, p.x, p.y);
				return;
			}

			graphics2d.setColor(primaryColor);
			graphics2d.fillRoundRect(0, 0, dimensions.width, dimensions.height, borderRadius, borderRadius);
			graphics2d.setColor(textColor);
			Point p = getTextPosition(font);
			graphics2d.drawString(text, p.x, p.y);

			if (isFocused) {
				graphics2d.setColor(focusColor);
				graphics2d.fillOval(dimensions.width - 10, dimensions.height - 10, 10, 10);
			}
		}
	}

	private Point getTextPosition(Font font) {
		FontMetrics fm = getFontMetrics(font);
		int lineWidth = 0;
		for (int i = 0; i < text.length(); i++) {
			lineWidth += fm.charWidth(text.charAt(i));
		}
		int lineHeight = fm.getHeight();
		int x = getSize().width / 2 - lineWidth / 2;
		int y = getPreferredSize().height / 2 + lineHeight / 4 + lineHeight / 8;
		return new Point(x, y);
	}

	private MouseListener mouseListener = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				mousePressed = false;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1)
				mousePressed = true;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			MaterialButton.this.hover = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			MaterialButton.this.hover = true;
		}

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub

		}
	};

	private FocusListener focusListener = new FocusListener() {

		@Override
		public void focusLost(FocusEvent e) {
			MaterialButton.this.isFocused = false;
		}

		@Override
		public void focusGained(FocusEvent e) {
			MaterialButton.this.isFocused = true;
		}
	};

}
