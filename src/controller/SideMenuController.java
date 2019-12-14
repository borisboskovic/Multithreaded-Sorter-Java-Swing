package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.PanelButton;
import model.PanelSwitchingModel;
import view.SideMenuView;

public class SideMenuController {

	private PanelSwitchingModel model;
	private SideMenuView view;

	public SideMenuController(PanelSwitchingModel model, SideMenuView view) {
		this.model = model;
		this.view = view;
		for(PanelButton button:model.getButtons()) {
			button.addActionListener(activeButtonSwitcher);
		}
	}
	
	private ActionListener activeButtonSwitcher=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			model.setActive(model.getButtons().indexOf((PanelButton)e.getSource()));
			model.notifyObservers();
		}
	};

}
