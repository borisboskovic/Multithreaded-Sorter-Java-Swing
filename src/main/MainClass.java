package main;

import model.PanelSwitchingModel;
import view.MainWindow;

public class MainClass {

	public static void main(String[] args) {
		new MainWindow(new PanelSwitchingModel());
	}

}
