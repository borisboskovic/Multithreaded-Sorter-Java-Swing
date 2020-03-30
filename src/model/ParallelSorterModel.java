package model;

import java.util.ArrayList;

public class ParallelSorterModel {

	private ArrayList<SerialSorterModel> serialSorters;

	public ParallelSorterModel(ArrayList<Integer> array, int threadCount, int filesPerThread) {

		serialSorters = new ArrayList<>();
	}

}
