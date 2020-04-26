package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.SettingsModel;
import settings.Context;
import view.SettingsView;

public class SettingsController {
	private SettingsModel model;
	private SettingsView view;

	public SettingsController(SettingsModel model, SettingsView view) {
		this.model = model;
		this.view = view;
		view.getApplyBtn().addActionListener(applyBtnListener);
	}

	private ActionListener applyBtnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Context context = Context.getContext();
			String selectedTheme = view.getThemesCmbBox().getSelectedItem().toString();
			model.getPreferences().setThemeName(selectedTheme);
			context.setColorTheme(model.getThemes().get(selectedTheme));
			context.savePreferences();
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
			topFrame.repaint();
			System.out.println(topFrame);
		}
	};
}
