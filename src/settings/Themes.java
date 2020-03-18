/******************************************************************************
 * Author: Milica Milosevic, Boris Boskovic
 * Purpose: Singleton klasa Themes. Pri kreiranju dohvata sve teme i registruje
 * 		izabranu temu
 *****************************************************************************/
package settings;

import java.awt.Color;
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
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

	private static void getFromFile() {
		registerFonts();
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
				reader = new BufferedReader(new FileReader(th));
				Gson gson = new GsonBuilder().create();
				ColorTheme temp = gson.fromJson(reader, ColorTheme.class);
				allThemes.put(temp.getThemeName(), temp);
			}
			theme = allThemes.get(activeThemeName);

			reader.close();
		} catch (IOException | NullPointerException e) {
			generateDefaultTheme();
		}
	}

	/**
	 * Metoda registruje sve fontove iz foldera fonts u graficko okruzenje
	 */
	private static void registerFonts() {
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

	public static void generateDefaultTheme() {
		ColorTheme defaultTheme = new ColorTheme();

		defaultTheme.setThemeColor(new Color(92, 92, 92));
		defaultTheme.setThemeDarkerColor(new Color(58, 58, 58));
		defaultTheme.setThemeLighterColor(new Color(117, 117, 117));

		defaultTheme.setSectionColor(new Color(197, 197, 197));
		defaultTheme.setBackgroundColor(Color.WHITE);

		defaultTheme.setTextPrimaryColor(new Color(50, 50, 50));
		defaultTheme.setTextSecondaryColor(Color.WHITE);

		defaultTheme.setAccentColor(new Color(255, 140, 0));
		defaultTheme.setAccentColor(new Color(3,102,214));
		defaultTheme.setAccentLighterColor(new Color(255, 170, 0));
		defaultTheme.setSpecialColor(Color.BLACK);

		defaultTheme.setThemeName("default-gray");
		defaultTheme.setBackgroundImageUrl("resources/images/numbers.png");
		
		// Postavljanje fontova
		FontTheme fonts = new FontTheme();
		fonts.setPanelButtonFont(new Font("Roboto Cn", Font.PLAIN, 20));
		fonts.setMainButtonFont(new Font("Roboto Cn", Font.PLAIN, 24));
		fonts.setLabelFont(new Font("Roboto Cn", Font.PLAIN, 20));
		fonts.setTextFieldFont(new Font("Roboto Cn", Font.PLAIN, 18));
		fonts.setStatusBarFont(new Font("Roboto Cn", Font.PLAIN, 18));
		fonts.setImportantFont(new Font("Roboto Cn", Font.BOLD | Font.ITALIC, 36));
		fonts.setNoteFont(new Font("Roboto Cn", Font.ITALIC, 14));

		defaultTheme.setFonts(fonts);
		Themes.theme = defaultTheme;

		// Zapis u fajl
		Gson gson = new GsonBuilder().create();
		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter("resources\\themes\\" + defaultTheme.getThemeName() + ".json"));
			gson.toJson(defaultTheme, writer);
			writer.close();
		} catch (IOException e) {
		}
	}
}
