package model;

import java.io.File;
import java.util.ArrayList;

import algorithm.SortingAlgorithm;

public class MultiSorterModel {
	
	private SortingAlgorithm algorithm;
	private ArrayList<PathSectionModel> pathModels=null;
	
	public MultiSorterModel() {
		this.pathModels=new ArrayList<>();
		pathModels.add(new PathSectionModel(1, "C:\\Users\\Boris\\Desktop\\Portal.exe"));
	}
	
	public ArrayList<PathSectionModel> getPathModels() {
		return pathModels;
	}
	
	public void addFiles(File[] files) {
		if(pathModels==null)
			pathModels=new ArrayList<>();
		
	}
}
