package view;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import components.MaterialButton;
import components.MaterialComboBox;
import controller.SettingsController;
import model.SettingsModel;
import settings.Context;

@SuppressWarnings("serial")
public class SettingsView extends JPanel {
	private JComboBox<String> themesCmbBox;
	private JButton applyBtn;
	private SettingsModel model;

	public SettingsView(SettingsModel model) {
		Vector<String> themeNames = new Vector<>(model.getThemes().keySet());
		themesCmbBox = new MaterialComboBox<>(themeNames);
		themesCmbBox.setSelectedItem(Context.getContext().getColorTheme().getThemeName());
		add(themesCmbBox);

		applyBtn = new MaterialButton("Apply");
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
