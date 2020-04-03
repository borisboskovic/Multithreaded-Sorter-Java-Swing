package model;

import java.util.ArrayList;

import algorithm.SortingAlgorithm;
import settings.Algorithms;

public class SerialSorterModel implements Runnable {

	private ArrayList<SortingAlgorithm> sorters;

	public SerialSorterModel(ArrayList<Integer> array, int numOfFiles, String algorithmName) {
		sorters = new ArrayList<>();
		for (int i = 0; i < numOfFiles; i++)
			sorters.add(Algorithms.getInstance().createAlgorithm(algorithmName, array));
	}

	
	public void sort() {
		for(SortingAlgorithm sorter : sorters)
			sorter.sort(null);
	}


	@Override
	public void run() {
		
	}
	
}
