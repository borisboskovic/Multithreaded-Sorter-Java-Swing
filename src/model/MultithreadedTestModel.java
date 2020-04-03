package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.MultithreadedTestView;

public class MultithreadedTestModel {
	public static final int FILES_LIMIT = 20;

	private ArrayList<Integer> array;
	private MultithreadedTestView view;
	private int maxThreads;
	private int minFilesPerThread;
	private String algorithmName;
	private String path;

	private ArrayList<ParallelSorterModel> sorters;

	public void runTests() {
		readDataFromFile(path);
		createSorters();

	}

	public void createSorters() {
		sorters = new ArrayList<>();
		for (int i = 1; i <= maxThreads; i *= 2)
			sorters.add(new ParallelSorterModel(array, i, maxThreads * minFilesPerThread / i, algorithmName));
	}

	public void setView(MultithreadedTestView view) {
		this.view = view;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setMaxThreads(int maxThreads) {
		this.maxThreads = maxThreads;
	}

	public void setMinFilesPerThread(int minFilesPerThread) {
		this.minFilesPerThread = minFilesPerThread;
	}

	private void readDataFromFile(String path) {
		array = new ArrayList<>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(path)));
			Pattern pattern = Pattern.compile("\\d+");
			while (in.ready()) {
				Matcher matcher = pattern.matcher(in.readLine());
				while (matcher.find())
					array.add(Integer.valueOf(matcher.group()));
			}
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

}
