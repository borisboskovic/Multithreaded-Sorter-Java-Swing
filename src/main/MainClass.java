package main;

import global.Themes;
import model.GeneratorSectionModel;
import model.InfoModel;
import view.MainWindow;

public class MainClass{
	
	public static void main(String[] args) {
		Themes.generateDefaultTheme();
		
		new MainWindow();
		
		//TODO: Add about and help sections
		//TODO: Add Font family selection to settings
		
	}

}
