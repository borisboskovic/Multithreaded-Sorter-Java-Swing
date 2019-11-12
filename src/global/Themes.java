/******************************************************************************
 * Author: Milica Milosevic, Boris Boskovic
 * Purpose: Singleton klasa Themes. Pri kreiranju dohvata sve teme i registruje
 * 		izabranu temu
 *****************************************************************************/
package global;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import settings.ColorTheme;

public class Themes {
	private static ColorTheme theme = null;
	private static HashMap<String, ColorTheme> allThemes = new HashMap<>();

	private Themes() {
	}

	public static ColorTheme getCurrentTheme() {
		if (theme == null)
			getFromFile();
		return theme;
	}

	public static void refresh() {
		getFromFile();
	}

	private static void generateDefaultTheme() {
		ColorTheme defaultTheme = new ColorTheme();

		defaultTheme.setThemeName("default-blue");
		defaultTheme.setThemeColor(new Color(32, 135, 255));
		defaultTheme.setSecondaryTextColor(Color.WHITE);
		defaultTheme.setSeparatorColor(Color.WHITE);
		defaultTheme.setDangerColor(new Color(240, 0, 0));
		defaultTheme.setSectionColor(new Color(232, 232, 232));
		defaultTheme.setPrimaryButtonColor(new Color(32, 135, 255));
		defaultTheme.setSecondaryButtonColor(new Color(240, 0, 0));
		defaultTheme.setInputAccentColor(new Color(32, 135, 255));
		defaultTheme.setInputMainColor(new Color(195, 195, 195));
		defaultTheme.setOptionalButtonColor(new Color(195, 195, 195));
		defaultTheme.setSpecialInfoColor(Color.BLACK);
		defaultTheme.setMainPanelColor(Color.WHITE);
		defaultTheme.setPrimaryTextColor(Color.BLACK);

		Themes.theme = defaultTheme;

		Gson gson = new GsonBuilder().create();

		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("resources\\themes\\" + defaultTheme.getThemeName() + ".json"));
			gson.toJson(defaultTheme, writer);
			writer.close();
		} catch (IOException e) {
		}
	}

	private static void getFromFile() {
		theme = null;
		allThemes = new HashMap<>();
		String activeThemeName;
		try {
			BufferedReader readerActive = new BufferedReader(new FileReader("preferences\\active-theme"));
			activeThemeName = readerActive.readLine();
			readerActive.close();

			File themesDirectory = new File("resources\\themes");
			File[] themes = themesDirectory.listFiles();
			BufferedReader reader = null;

			for (File th : themes) {
				System.out.println(th);
				reader = new BufferedReader(new FileReader(th));
				Gson gson = new GsonBuilder().create();
				ColorTheme temp = gson.fromJson(reader, ColorTheme.class);
				allThemes.put(temp.getThemeName(), temp);
			}
			theme = allThemes.get(activeThemeName);

			reader.close();
		} catch (IOException e) {
			generateDefaultTheme();
		}
	}

}
