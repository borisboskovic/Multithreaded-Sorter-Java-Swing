package model;

import java.util.ArrayList;

import components.PanelButton;

public class SideMenuModel {

	private ArrayList<PanelButton> buttons;

	public SideMenuModel() {
		buttons = new ArrayList<>();
		PanelButton button1 = new PanelButton("System Info");
		PanelButton button2 = new PanelButton("Generate test data");
		PanelButton button3 = new PanelButton("Sort multiple files");
		PanelButton button4 = new PanelButton("Sort singlethreaded");
		PanelButton button5 = new PanelButton("Compare performances");
		PanelButton button6 = new PanelButton("Settings");

		// TODO: Dodaj action commands

		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		buttons.add(button6);

		buttons.get(0).setActive(true);
	}

	public ArrayList<PanelButton> getButtons() {
		return buttons;
	}

	public PanelButton getActiveButton() {
		PanelButton activeButton = buttons.get(0);
		for (PanelButton button : buttons)
			if (button.getActive())
				activeButton = button;
		return activeButton;
	}

}
