package main;

import model.PanelSwitchingModel;
import model.SettingsModel;
import settings.Context;
import settings.Preferences;
import view.MainWindow;

public class MainClass {

	public static void main(String[] args) {
		
		new MainWindow(new PanelSwitchingModel());

		// TODO: Add about and help sections
		// TODO: Add Font family selection to settings
		// TODO: Uskladiti dugmad i panele tako da nema IndexOutOfBounds Exception
		// TODO: Uraditi validaciju podataka u generatoru
		// TODO: Provjeri da li sortiranje radi sa negativnim brojevima
		// TODO: Dodaj konzolu, ispisuj poruke, text area readonly
	}

}
