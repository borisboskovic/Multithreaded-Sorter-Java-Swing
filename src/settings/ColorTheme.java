package settings;

import java.awt.Color;

public class ColorTheme {
	private Color themeColor;
	private Color themeDarkerColor;
	private Color themeLighterColor;

	private Color sectionColor;
	private Color backgroundColor;

	private Color textPrimaryColor;
	private Color textSecondaryColor;

	private Color accentColor;
	private Color accentLighterColor;
	private Color specialColor;

	private String themeName;

	private String backgroundImageUrl = null;
	private FontTheme fonts;

	public Color getThemeColor() {
		return themeColor;
	}

	public void setThemeColor(Color themeColor) {
		this.themeColor = themeColor;
	}

	public Color getThemeDarkerColor() {
		return themeDarkerColor;
	}

	public void setThemeDarkerColor(Color themeDarkerColor) {
		this.themeDarkerColor = themeDarkerColor;
	}

	public Color getThemeLighterColor() {
		return themeLighterColor;
	}

	public void setThemeLighterColor(Color themeLighterColor) {
		this.themeLighterColor = themeLighterColor;
	}

	public Color getSectionColor() {
		return sectionColor;
	}

	public void setSectionColor(Color sectionColor) {
		this.sectionColor = sectionColor;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getTextPrimaryColor() {
		return textPrimaryColor;
	}

	public void setTextPrimaryColor(Color textPrimaryColor) {
		this.textPrimaryColor = textPrimaryColor;
	}

	public Color getTextSecondaryColor() {
		return textSecondaryColor;
	}

	public void setTextSecondaryColor(Color textSecondaryColor) {
		this.textSecondaryColor = textSecondaryColor;
	}

	public Color getAccentColor() {
		return accentColor;
	}

	public void setAccentColor(Color accentColor) {
		this.accentColor = accentColor;
	}

	public Color getAccentLighterColor() {
		return accentLighterColor;
	}

	public void setAccentLighterColor(Color accentLighterColor) {
		this.accentLighterColor = accentLighterColor;
	}

	public Color getSpecialColor() {
		return specialColor;
	}

	public void setSpecialColor(Color specialColor) {
		this.specialColor = specialColor;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}

	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}

	public FontTheme getFonts() {
		return fonts;
	}

	public void setFonts(FontTheme fonts) {
		this.fonts = fonts;
	}
}
