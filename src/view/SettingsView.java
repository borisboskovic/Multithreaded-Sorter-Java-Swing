package view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import components.MaterialButton;
import components.MaterialComboBox;
import controller.SettingsController;
import model.SettingsModel;

@SuppressWarnings("serial")
public class SettingsView extends JPanel {
	private JComboBox<String> themesCmbBox;
	private JButton applyBtn;
	private SettingsModel model;

	public SettingsView(SettingsModel model) {
		Vector<String> themeNames = new Vector<>(model.getThemes().keySet());
		this.themesCmbBox = new MaterialComboBox<>(themeNames);
		add(themesCmbBox);

		this.applyBtn = new MaterialButton("Apply");
		add(applyBtn);
		
		new SettingsController(model, this);
	}
	
	public JButton getApplyBtn() {
		return applyBtn;
	}
	
	public JComboBox<String> getThemesCmbBox() {
		return themesCmbBox;
	}
}
