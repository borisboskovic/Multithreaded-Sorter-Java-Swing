/******************************************************************************
 * Author: Milica Milosevic, Boris Boskovic
 * Purpose: Singleton klasa Fonts. Pri kreiranju dohvata i registruje fontove
 * 		koji se nalaze u resursima.
 *****************************************************************************/
package global;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fonts {

	private static Fonts fonts = null;

	/**
	 * Private Constructor (Singletone class)
	 */
	private Fonts() {
		registerFonts();
	}

	/**
	 * Metoda registruje sve fontove iz foldera fonts u graficko okruzenje
	 */
	public void registerFonts() {
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
	 * Metoda koja dohvaca ime trenutno podesenog fajla. Ime se cuva u:
	 * resoures/current-font
	 * 
	 * @return Naziv trenutno podesenog fonta
	 */
	public static String getCurrentFontName() throws NullPointerException {
		if (fonts == null)
			fonts = new Fonts();

		String fontFamilyName = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("preferences/current-font"));
			fontFamilyName = in.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fontFamilyName;
	}

	/**
	 * @return Singleton instanca klase Fonts
	 */
	public static Fonts getInstance() {
		if (fonts == null)
			fonts = new Fonts();
		return fonts;
	}

	/**
	 * Omogucava osvjezavanje singleton klase. Kreiranje nove instance je pozeljno
	 * npr u slucaju kada se resursi promijene izvana
	 */
	public static void refresh() {
		fonts = new Fonts();
	}
}