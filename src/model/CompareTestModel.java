package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import algorithm.QuickSort;
import algorithm.QuickSortMultithreaded;

public class CompareTestModel {
	private ArrayList<Integer> array;
	private int maxThreads;

	public CompareTestModel(String path, int maxThreads) {
		readFile(path);
		this.maxThreads = maxThreads;
	}

	// Reads numbers from file and adds them in the collection
	private void readFile(String path) {
		this.array = new ArrayList<>();
		Pattern patteern = Pattern.compile("\\d+");
		Matcher matcher;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while (reader.ready()) {
				String line = reader.readLine();
				matcher = patteern.matcher(line);
				while (matcher.find())
					this.array.add(Integer.valueOf(matcher.group()));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runTest() {
		QuickSortMultithreaded sorter = new QuickSortMultithreaded(array, maxThreads);
		QuickSort sorterSingle=new QuickSort(new ArrayList<>(array));
		Thread thread = new Thread(sorter);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Multi: "+sorter.getDuration()+"ms");
		
		System.out.println("Single: "+sorterSingle.sort(null)+"ms");
		
	}
}
