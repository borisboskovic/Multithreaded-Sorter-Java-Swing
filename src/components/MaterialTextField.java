package components;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import global.Themes;

@SuppressWarnings("serial")
public class MaterialTextField extends JTextField {

	private Font font;

	public MaterialTextField(int length) {
		super(length);
		font = Themes.getCurrentTheme().getFonts().getTextFieldFont();
		setFont(font);
		applyStyle();
	}

	private void applyStyle() {
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 2, 0, Themes.getCurrentTheme().getThemeColor()),
				BorderFactory.createEmptyBorder(5, 10, 0, 10)));

		setBackground(Themes.getCurrentTheme().getThemeColor());
		setForeground(Themes.getCurrentTheme().getTextSecondaryColor());
		setCaretColor(Themes.getCurrentTheme().getTextSecondaryColor());

		setCaretPosition(0);
	}

}
