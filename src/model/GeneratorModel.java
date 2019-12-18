package model;

import java.util.ArrayList;

public class GeneratorModel {

	private ArrayList<GeneratorSectionModel> generators;

	public GeneratorModel() {
		generators = new ArrayList<>();
		generators.add(new GeneratorSectionModel(1));
		generators.add(new GeneratorSectionModel(2));
		generators.add(new GeneratorSectionModel(3));
	}

	public ArrayList<GeneratorSectionModel> getGenerators() {
		return generators;
	}
	
}