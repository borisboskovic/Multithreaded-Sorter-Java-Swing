package model;

import java.util.ArrayList;

import view.ObserverInterface;

public class GeneratorModel implements SubjectInterface{

	private ArrayList<GeneratorSectionModel> generators;

	public GeneratorModel() {
		generators = new ArrayList<>();
		GeneratorSectionModel model=new GeneratorSectionModel();
		model.setSectionNumber(1);
		generators.add(model);
	}

	public ArrayList<GeneratorSectionModel> getGenerators() {
		return generators;
	}

	@Override
	public void addObserver(ObserverInterface observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(ObserverInterface observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
	
}