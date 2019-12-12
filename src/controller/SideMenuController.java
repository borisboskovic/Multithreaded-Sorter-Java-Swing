package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import components.PanelButton;
import model.SideMenuModel;
import view.SideMenuView;

public class SideMenuController {

	private SideMenuModel model;
	private SideMenuView view;

	public SideMenuController(SideMenuModel model, SideMenuView view) {
		this.model = model;
		this.view = view;
		for(PanelButton button:model.getButtons()) {
			button.addActionListener(activeButtonSwitcher);
		}
	}
	
	private ActionListener activeButtonSwitcher=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!((PanelButton)e.getSource()).getActive()) {
				for(PanelButton button:model.getButtons())
					button.setActive(false);
			}
			((PanelButton)e.getSource()).setActive(true);
			view.repaint();
		}
	};

}
