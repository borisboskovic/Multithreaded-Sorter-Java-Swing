package components;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import global.Fonts;
import global.Themes;

public class MaterialTextField extends JTextField {

	private Font font;

	public MaterialTextField(int length) {
		super(length);
		font = new Font(Fonts.getCurrentFontName(), Font.PLAIN, 22);
		setFont(font);
		applyStyle();
	}

	private void applyStyle() {
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Themes.getCurrentTheme().getThemeColor(), 0),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		setBackground(Themes.getCurrentTheme().getInputMainColor());
		setCaretColor(Themes.getCurrentTheme().getPrimaryTextColor());
		setForeground(Themes.getCurrentTheme().getPrimaryTextColor());
//		setPreferredSize(new Dimension(100, 50));
		setCaretPosition(0);
	}

}
