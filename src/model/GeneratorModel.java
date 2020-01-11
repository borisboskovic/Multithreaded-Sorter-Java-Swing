package model;

import java.util.ArrayList;

import view.ObserverInterface;

public class GeneratorModel implements SubjectInterface {
	private ArrayList<ObserverInterface> observers = null;
	private ArrayList<GeneratorSectionModel> generators;

	public GeneratorModel() {
		generators = new ArrayList<>();
		GeneratorSectionModel model = new GeneratorSectionModel();
		model.setSectionNumber(1);
		generators.add(model);
	}

	public void addGenerator(GeneratorSectionModel generator) {
		generator.setSectionNumber(generators.size() + 1);
		generators.add(generator);

	}

	public void clearGenerators() {
		generators = new ArrayList<>();
	}

	public ArrayList<GeneratorSectionModel> getGenerators() {
		return generators;
	}

	@Override
	public void addObserver(ObserverInterface observer) {
		if (observers == null)
			observers = new ArrayList<>();
		observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverInterface observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < generators.size(); i++) {
			generators.get(i).setSectionNumber(i + 1);
		}

		for (ObserverInterface o : observers) {
			o.update();
		}
	}

	public void generateAll() {
		for (GeneratorSectionModel sectionModel : generators)
			sectionModel.generate();
	}

}