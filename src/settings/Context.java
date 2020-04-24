package settings;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Context {
	private static Context instance = null;
	private Preferences preferences;
	private ColorTheme colorTheme;
	private FontTheme fonts;

	private Context() {
		registerFonts();
		readPreferences();
		readTheme();
		readFonts();
	}

	public static Context getContext() {
		if (instance == null)
			instance = new Context();
		return instance;
	}

	/**
	 * Reads preferences from file
	 */
	private void readPreferences() {
		Gson gson = new GsonBuilder().create();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("preferences" + File.separator + "current.json"));
			preferences = gson.fromJson(reader, Preferences.class);
			reader.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Reads color theme from file
	 */
	private void readTheme() {
		Gson gson = new GsonBuilder().create();
		try {
			File themeFile = new File(
					"resources" + File.separator + "themes" + File.separator + preferences.getThemeName() + ".json");
			BufferedReader reader = new BufferedReader(new FileReader(themeFile));
			colorTheme = gson.fromJson(reader, ColorTheme.class);
			reader.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Reads font settings from file
	 */
	private void readFonts() {
		Gson gson = new GsonBuilder().create();
		try {
			BufferedReader reader = new BufferedReader(
					new FileReader("resources" + File.separator + "font-settings.json"));
			fonts = gson.fromJson(reader, FontTheme.class);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Registers user fonts to graphical ennvironment
	 */
	public static void registerFonts() {
		File fontsDirectory = new File("resources//fonts");
		File[] fontFiles = fontsDirectory.listFiles();

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		FileInputStream inputStream = null;
		for (File file : fontFiles) {
			try {
				inputStream = new FileInputStream(file);
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, inputStream));
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Writes default preferences to file
	 */
	public static void writeDefaultPreferences() {
		Preferences pref = new Preferences();
		pref.setThemeName("default-gray");
		pref.setLanguage("english");
		pref.setSplineRenderer(false);
		pref.setMaxThreadsAllowed(32);
		pref.setFilesLimit(5);

		Gson gson = new GsonBuilder().create();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("preferences" + File.separator + "current.json"));
			gson.toJson(pref, writer);
			writer.close();
		} catch (IOException e) {
		}
	}

	public static void writeDefaultTheme() {

	}

	public static void writeDefaultFontSettings() {
		FontTheme fonts = new FontTheme();
		fonts.setPanelButtonFont(new Font("Roboto Cn", Font.PLAIN, 20));
		fonts.setMainButtonFont(new Font("Roboto Cn", Font.PLAIN, 24));
		fonts.setLabelFont(new Font("Roboto Cn", Font.PLAIN, 20));
		fonts.setTextFieldFont(new Font("Roboto Cn", Font.PLAIN, 18));
		fonts.setStatusBarFont(new Font("Roboto Cn", Font.PLAIN, 18));
		fonts.setImportantFont(new Font("Roboto Cn", Font.BOLD | Font.ITALIC, 36));
		fonts.setNoteFont(new Font("Roboto Cn", Font.ITALIC, 14));

		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("resources" + File.separator + "font-settings.json"));
			Gson gson = new GsonBuilder().create();
			gson.toJson(fonts, writer);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public ColorTheme getColorTheme() {
		return colorTheme;
	}

	public FontTheme getFonts() {
		return fonts;
	}
}
