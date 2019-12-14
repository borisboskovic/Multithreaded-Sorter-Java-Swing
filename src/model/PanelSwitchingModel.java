package model;

import java.util.ArrayList;

import components.PanelButton;
import view.ObserverInterface;

public class PanelSwitchingModel implements SubjectInterface {

	private ArrayList<ObserverInterface> observers;

	private ArrayList<PanelButton> buttons;
	private int active;

	public PanelSwitchingModel() {
		observers = new ArrayList<>();
		populateButtons();
		active = 0;
	}

	private void populateButtons() {
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
	}

	public ArrayList<PanelButton> getButtons() {
		return buttons;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
		for (PanelButton b : buttons) {
			if (buttons.indexOf(b) == active)
				b.setPressed(true);
			else
				b.setPressed(false);
		}
	}

	@Override
	public void addObserver(ObserverInterface observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverInterface observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverInterface observer : observers) {
			observer.update();
		}
	}

}
