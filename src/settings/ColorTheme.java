package settings;

import java.awt.Color;

public class ColorTheme {
	private Color themeColor;
	private Color mainPanelColor;
	private Color primaryTextColor;
	private Color secondaryTextColor;
	private Color separatorColor;
	private Color dangerColor;
	private Color sectionColor;
	private Color primaryButtonColor;
	private Color secondaryButtonColor;
	private Color optionalButtonColor;
	private Color inputAccentColor;
	private Color inputMainColor;
	private Color specialInfoColor;
	
	private String themeName;
	
	private FontTheme fonts;

	public Color getThemeColor() {
		return themeColor;
	}
	
	public FontTheme getFonts() {
		return fonts;
	}
	
	public void setFonts(FontTheme fonts) {
		this.fonts = fonts;
	}

	public void setThemeColor(Color themeColor) {
		this.themeColor = themeColor;
	}

	public Color getMainPanelColor() {
		return mainPanelColor;
	}

	public void setMainPanelColor(Color mainPanelColor) {
		this.mainPanelColor = mainPanelColor;
	}

	public Color getPrimaryTextColor() {
		return primaryTextColor;
	}

	public void setPrimaryTextColor(Color primaryTextColor) {
		this.primaryTextColor = primaryTextColor;
	}

	public Color getSecondaryTextColor() {
		return secondaryTextColor;
	}

	public void setSecondaryTextColor(Color secondaryTextColor) {
		this.secondaryTextColor = secondaryTextColor;
	}

	public Color getSeparatorColor() {
		return separatorColor;
	}

	public void setSeparatorColor(Color separatorColor) {
		this.separatorColor = separatorColor;
	}

	public Color getDangerColor() {
		return dangerColor;
	}

	public void setDangerColor(Color dangerColor) {
		this.dangerColor = dangerColor;
	}

	public Color getSectionColor() {
		return sectionColor;
	}

	public void setSectionColor(Color sectionColor) {
		this.sectionColor = sectionColor;
	}

	public Color getPrimaryButtonColor() {
		return primaryButtonColor;
	}

	public void setPrimaryButtonColor(Color primaryButtonColor) {
		this.primaryButtonColor = primaryButtonColor;
	}

	public Color getSecondaryButtonColor() {
		return secondaryButtonColor;
	}

	public void setSecondaryButtonColor(Color secondaryButtonColor) {
		this.secondaryButtonColor = secondaryButtonColor;
	}

	public Color getOptionalButtonColor() {
		return optionalButtonColor;
	}

	public void setOptionalButtonColor(Color optionalButtonColor) {
		this.optionalButtonColor = optionalButtonColor;
	}

	public Color getInputAccentColor() {
		return inputAccentColor;
	}

	public void setInputAccentColor(Color inputAccentColor) {
		this.inputAccentColor = inputAccentColor;
	}

	public Color getInputMainColor() {
		return inputMainColor;
	}

	public void setInputMainColor(Color inputMainColor) {
		this.inputMainColor = inputMainColor;
	}

	public Color getSpecialInfoColor() {
		return specialInfoColor;
	}

	public void setSpecialInfoColor(Color specialInfoColor) {
		this.specialInfoColor = specialInfoColor;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}
	
	
}
