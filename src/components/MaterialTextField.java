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
				BorderFactory.createLineBorder(Themes.getCurrentTheme().getThemeColor(), 0),
				BorderFactory.createEmptyBorder(5, 10, 0, 10)));
//		setBorder(BorderFactory.createCompoundBorder(
//		BorderFactory.createMatteBorder(0, 0, 1, 0, Themes.getCurrentTheme().getThemeColor()),
//		BorderFactory.createEmptyBorder(5, 10, 0, 10)));
		
//		setBackground(Themes.getCurrentTheme().getInputMainColor());
//		setCaretColor(Themes.getCurrentTheme().getPrimaryTextColor());
//		setForeground(Themes.getCurrentTheme().getPrimaryTextColor());
		setCaretPosition(0);
	}

}
