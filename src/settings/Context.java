package settings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Context {
	private static Context instance = null;
	private Preferences preferences;
	private ColorTheme colorTheme;

	private Context() {
		readPreferences();
		readTheme();
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
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("preferences" + File.separator + "current.json"));
			preferences = gson.fromJson(reader, Preferences.class);
			reader.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Reads theme from file
	 */
	private void readTheme() {
		Gson gson = new GsonBuilder().create();
		BufferedReader reader;
		try {
			File themeFile = new File(
					"resources" + File.separator + "themes" + File.separator + preferences.getThemeName() + ".json");
			reader = new BufferedReader(new FileReader(themeFile));
			colorTheme = gson.fromJson(reader, ColorTheme.class);
			reader.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Writes default preferences to file
	 */
	public void writeDefaultPreferences() {
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
	
	public void writeDefaultTheme() {
		
	}

	public Preferences getPreferences() {
		return preferences;
	}

	public ColorTheme getColorTheme() {
		return colorTheme;
	}
}
