package settings;

import java.util.ArrayList;
import java.util.Vector;

import algorithm.BubbleSort;
import algorithm.InsertionSort;
import algorithm.QuickSort;
import algorithm.SortingAlgorithm;

public class Algorithms {

	private static Algorithms instance = null;

	private Vector<String> list;

	private Algorithms() {
		list = new Vector<>();
		list.add("Quick Sort");
		list.add("Bubble Sort");
		list.add("Insertion Sort");
		list.add("Add ...");
	};

	public static Algorithms getInstance() {
		if (instance == null)
			instance = new Algorithms();
		return instance;
	}

	public Vector<String> getList() {
		return list;
	}

	// TODO: dodati algoritme }
	public SortingAlgorithm createAlgorithm(String name, ArrayList<Integer> array) {
		if (name.equals(list.get(0)))
			return new QuickSort(array);
		else if (name.equals(list.get(1)))
			return new BubbleSort(array);
		else if (name.equals(list.get(2)))
			return new InsertionSort(array);
		else
			return null;
	}

}
