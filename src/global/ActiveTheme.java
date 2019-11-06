package global;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import settings.ColorTheme;

public class ActiveTheme {
	private static ColorTheme theme = null;

	private ActiveTheme() {
	}

	public static ColorTheme getInstance() {
		if (theme == null)
			getFromFile();
		return theme;
	}

	private static void getFromFile() {
		String activeThemeName;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("preferences\\active-theme"));
			activeThemeName = reader.readLine();
			reader.close();

			File themesDirectory = new File("resources\\themes");
			File[] themes = themesDirectory.listFiles();
			for (File th : themes) {
				if (th.getName().contains(activeThemeName)) {
					BufferedReader reader2 = new BufferedReader(new FileReader(th));
					Gson gson = new GsonBuilder().create();
					theme = gson.fromJson(reader2, ColorTheme.class);
				}
			}
		} catch (IOException e) {
			generateDefaultTheme();
		}
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

		ActiveTheme.theme = defaultTheme;

		Gson gson = new GsonBuilder().create();

		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("resources\\themes\\" + defaultTheme.getThemeName() + ".json"));
			gson.toJson(defaultTheme, writer);
			writer.close();
		} catch (IOException e) {
//
		}
	}

}
