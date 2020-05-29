package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.SettingsModel;
import view.SettingsView;

public class SettingsController {
	private SettingsModel model;
	private SettingsView view;

	public SettingsController(SettingsModel model, SettingsView view) {
		this.model = model;
		this.view = view;
		view.getApplyBtn().addActionListener(applyBtnListener);
		view.getCancelBtn().addActionListener(cancelBtnListener);
	}

	private ActionListener applyBtnListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String theme = view.getThemesCmbBox().getSelectedItem().toString();
			String graphStyle=view.getGraphCmbBox().getSelectedItem().toString();
			int threads = Integer.valueOf(view.getThreadsTxt().getText());
			int files = Integer.valueOf(view.getFilesTxt().getText());
			model.saveSettings(theme, graphStyle, threads, files);
			
			JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
			topFrame.revalidate();
			topFrame.repaint();
		}
	};
	
	private ActionListener cancelBtnListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			view.updateFieldValues();
		}
	};
}
