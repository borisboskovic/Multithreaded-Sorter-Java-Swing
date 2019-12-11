package model;

import java.util.ArrayList;

import components.PanelButton;

public class SideMenuModel {

	private ArrayList<PanelButton> buttons;

	public SideMenuModel() {
		buttons = new ArrayList<>();
		buttons.add(new PanelButton("System Info"));
		buttons.add(new PanelButton("Generate test data"));
		buttons.add(new PanelButton("Sort multiple files"));
		buttons.add(new PanelButton("Sort singlethreaded"));
		buttons.add(new PanelButton("Compare performances"));
		buttons.get(0).setActive(true);
	}

	public ArrayList<PanelButton> getButtons() {
		return buttons;
	}

}
