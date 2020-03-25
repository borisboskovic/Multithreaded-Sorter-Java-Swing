package view;

import javax.swing.JPanel;

import model.MultithreadedTestModel;

public class MultithreadedTestView extends JPanel{
	private MultithreadedTestModel model;

	public MultithreadedTestView(MultithreadedTestModel model) {
		this.model = model;
	}
	
}
