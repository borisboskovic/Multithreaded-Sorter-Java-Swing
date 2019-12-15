package main;

import global.Themes;
import model.GeneratorModel;
import view.MainWindow;

public class MainClass{
	
	public static void main(String[] args) {
		Themes.generateDefaultTheme();
		
		new MainWindow();
		//TODO: Add about and help sections
		//TODO: Add Font family selection to settings
		
//		GeneratorModel model=new GeneratorModel();
//		model.setLocation("C:\\Users\\Boris\\Desktop\\RandomNumbers\\numbers.txt");
//		model.setAmmount(50);
//		model.setFrom(4);
//		model.setTo(10);
//		model.generate();
		
	}

}
