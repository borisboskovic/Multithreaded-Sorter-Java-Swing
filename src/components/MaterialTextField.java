package components;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import global.Themes;
import settings.ColorTheme;

@SuppressWarnings("serial")
public class MaterialTextField extends JTextField {

	private Font font;

	public MaterialTextField(int length) {
		super(length);
		font = Themes.getCurrentTheme().getFonts().getTextFieldFont();
		setFont(font);
		applyStyle();
		this.addFocusListener(selectOnFocus);
	}

	private void applyStyle() {
		ColorTheme theme = Themes.getCurrentTheme();

		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, theme.getThemeColor()),
				BorderFactory.createEmptyBorder(5, 10, 0, 10)));

		setBackground(theme.getThemeColor());
		setForeground(theme.getTextSecondaryColor());
		setCaretColor(theme.getTextSecondaryColor());
		setSelectionColor(theme.getAccentColor());
		setSelectedTextColor(theme.getTextSecondaryColor());

		setCaretPosition(0);

		setMinimumSize(new Dimension(0, 50));
		setSize(new Dimension(0, 50));
	}

	private FocusListener selectOnFocus = new FocusListener() {

		@Override
		public void focusLost(FocusEvent e) {
		}

		@Override
		public void focusGained(FocusEvent e) {
			MaterialTextField.this.selectAll();
		}
	};

}
