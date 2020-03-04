package model;

import java.util.ArrayList;

import algorithm.SortingAlgorithm;

public class MultiFileSorterModel {
	
	private SortingAlgorithm algorithm;
	private ArrayList<String> paths;
	
	public MultiFileSorterModel() {
		this.paths= new ArrayList<>();
		paths.add("C:\\Users\\Boris\\Desktop\\test.txt");
		paths.add("C:\\Program Files (x86)\\GOG.com");
	}
	
	public ArrayList<String> getPaths() {
		return paths;
	}
}
