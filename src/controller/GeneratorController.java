package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GeneratorModel;
import model.GeneratorSectionModel;
import view.GeneratorView;

public class GeneratorController {

	private GeneratorModel model;
	private GeneratorView view;
	
	public GeneratorController(GeneratorModel model, GeneratorView view) {
		this.model = model;
		this.view = view;
		view.getPlus().addActionListener(addButtonListener);
	}

	private ActionListener addButtonListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			model.getGenerators().add(new GeneratorSectionModel());
		}
	};
	
}
