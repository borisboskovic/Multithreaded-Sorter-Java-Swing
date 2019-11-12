package settings;

import java.awt.Font;

public class FontTheme {
	private Font panelButtonFont;
	private Font mainButtonFont;
	private Font labelFont;
	private Font textFieldFont;
	private Font statusBarFont;
	private Font importantFont;
	
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

	public void setPanelButtonFont(Font panelButtonFont) {
		this.panelButtonFont = panelButtonFont;
	}

	public void setMainButtonFont(Font mainButtonFont) {
		this.mainButtonFont = mainButtonFont;
	}

	public void setLabelFont(Font labelFont) {
		this.labelFont = labelFont;
	}

	public void setTextFieldFont(Font textFieldFont) {
		this.textFieldFont = textFieldFont;
	}

	public void setStatusBarFont(Font statusBarFont) {
		this.statusBarFont = statusBarFont;
	}
	
	public Font getImportantFont() {
		return importantFont;
	}
	
	public void setImportantFont(Font importantFont) {
		this.importantFont = importantFont;
	}
	
}
