/***********************************************************************
 * Module:  QuickSortMultithreaded.java
 * Author:  Boris
 * Purpose: Defines the Class QuickSortMultithreaded
 ***********************************************************************/

package algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class QuickSortMultithreaded implements SortingAlgorithm, Runnable {

	private ArrayList<Integer> array;
	private int down;
	private int up;
	private int currentDepth;
	private int maxDepth;

	private boolean done = false;
	private long duration;

	public QuickSortMultithreaded(ArrayList<Integer> array, int maxThreads) {
		this.array = array;
		this.down = 0;
		this.up = array.size() - 1;
		this.currentDepth = 0;
		this.maxDepth = 0;
		while (maxThreads > 1) {
			maxThreads /= 2;
			this.maxDepth++;
		}
	}

	public QuickSortMultithreaded(ArrayList<Integer> array, int maxDepth, int currentDepth, int down, int up) {
		this.array = array;
		this.down = down;
		this.up = up;
		this.currentDepth = currentDepth;
		this.maxDepth = maxDepth;
	}

	/**
	 * @param down - down limit
	 * @param up   - up limit
	 * @return pivot j
	 */
	private int partition(int down, int up) {
		int i = down, j = up;
		int pivot = array.get(down);
		while (i < j) {
			while (array.get(i) <= pivot && i < j)
				i++;
			while (array.get(j) > pivot) {
				j--;
			}
			if (i < j) {
				int temp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, temp);
			}
		}
		array.set(down, array.get(j));
		array.set(j, pivot);
		return j;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();

		if (down < up) {
			int j = partition(down, up);
			SortingAlgorithm sorter1;
			SortingAlgorithm sorter2;
				sorter1 = new QuickSort(array, down, j-1);
				sorter2 = new QuickSort(array, j+1, up);
				Thread thread1 = new Thread((QuickSort) sorter1);
				Thread thread2 = new Thread((QuickSort) sorter2);
				thread1.start();
				thread2.start();
				try {
//					startTime = System.currentTimeMillis();
					thread1.join();
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}

		this.duration = System.currentTimeMillis() - startTime;
		saveToFile();
	}

	private void saveToFile() {
		File file = new File("C:\\Users\\Boris\\Desktop\\output.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String string="";
			for(Integer br : array) {
				string+=br.toString()+", ";
			}
			writer.write(string);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public long sort(String[] args) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> getArray() {
		return this.array;
	}

	@Override
	public void setArray(ArrayList<Integer> array) {
		this.array = array;
	}

	public boolean isDone() {
		return done;
	}

	public long getDuration() {
		return duration;
	}

}