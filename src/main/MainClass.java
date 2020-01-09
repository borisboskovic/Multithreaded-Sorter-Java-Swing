package main;

import global.Themes;
import model.GeneratorSectionModel;
import model.InfoModel;
import model.PanelSwitchingModel;
import view.MainWindow;

public class MainClass{
	
	public static void main(String[] args) {
		Themes.generateDefaultTheme();
		
		new MainWindow(new PanelSwitchingModel());
		
		//TODO: Add about and help sections
		//TODO: Add Font family selection to settings
		//TODO: Uskladiti dugmad i panele tako da nema IndexOutOfBounds Exception
		//TODO: Uraditi validaciju podataka u generatoru
	}

}
