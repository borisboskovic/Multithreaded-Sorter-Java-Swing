package global;

import java.util.ArrayList;
import java.util.Vector;

import algorithm.SortingAlgorithm;

public class Algorithms {

	private static Algorithms instance = null;

	private Vector<String> list;

	private Algorithms() {
		list = new Vector<>();
		list.add("Quick Sort");
		list.add("Test 1 2 3");
		list.add("Bubble Sort");
		list.add("Insertion Sort");
	};

	public static Algorithms getInstance() {
		if (instance == null)
			instance = new Algorithms();
		return instance;
	}

	public Vector<String> getList() {
		return list;
	}

	/*
	 * public SortingAlgorithm createAlgorithm(String name) {
	 * if(name.equals(list.get(0))) { return new }else if(name.equals(list.get(1)))
	 * { return new }
	 * 
	 * //TODO: dodati algoritme }
	 */

}
