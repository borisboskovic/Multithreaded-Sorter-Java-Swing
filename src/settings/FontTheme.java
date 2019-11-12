package settings;

import java.awt.Font;

public class FontTheme {
	private Font panelButtonFont;
	private Font mainButtonFont;
	private Font labelFont;
	private Font textFieldFont;
	private Font statusBarFont;
	
	private String themeName;
	private String fontFamily;
	
	public String getThemeName() {
		return themeName;
	}
	
	public String getFontFamily() {
		return fontFamily;
	}
	
	public Font getPanelButtonFont() {
		return panelButtonFont;
	}
	public Font getMainButtonFont() {
		return mainButtonFont;
	}
	public Font getLabelFont() {
		return labelFont;
	}
	public Font getTextFieldFont() {
		return textFieldFont;
	}
	public Font getStatusBarFont() {
		return statusBarFont;
	}
}
