package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import settings.ColorTheme;
import settings.Context;
import settings.Preferences;

public class SettingsModel {
	private HashMap<String, ColorTheme> themes;
	private Preferences preferences;

	public SettingsModel() {
		loadThemes();
		preferences=Context.getContext().getPreferences();
	}

	/**
	 * Reads themes from file system and adds them to collection
	 */
	private void loadThemes() {
		this.themes = new HashMap<>();
		File themesDirectory = new File("resources" + File.separator + "themes");
		File[] themeFiles = themesDirectory.listFiles();
		BufferedReader reader;
		Gson gson = new GsonBuilder().create();
		for (File file : themeFiles) {
			try {
				reader = new BufferedReader(new FileReader(file));
				ColorTheme temp = gson.fromJson(reader, ColorTheme.class);
				this.themes.put(temp.getThemeName(), temp);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public HashMap<String, ColorTheme> getThemes() {
		return themes;
	}
	
	public Preferences getPreferences() {
		return preferences;
	}
}
