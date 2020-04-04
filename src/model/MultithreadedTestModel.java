package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jfree.data.xy.DefaultXYDataset;

import view.LineChartWindow;
import view.SorterProgressWindow;

public class MultithreadedTestModel implements Runnable {
	public static final int FILES_LIMIT = 20;

	private int maxThreads;
	private int minFilesPerThread;
	private String algorithmName;
	private String path;

	private ArrayList<Integer> array;
	private ArrayList<ParallelSorterModel> sorters;

	public void createSorters() {
		sorters = new ArrayList<>();
		for (int i = 1; i <= maxThreads; i *= 2)
			sorters.add(new ParallelSorterModel(new ArrayList<>(array), i, maxThreads * minFilesPerThread / i,
					algorithmName));
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

	@Override
	public void run() {
		System.out.println("Runing tests...");
		SorterProgressWindow progressWindow = new SorterProgressWindow();
		progressWindow.setDescription("Reading data from file..."); // TODO: Lokalizacija
		readDataFromFile(path);
		progressWindow.setDescription("Creating sorters...");
		createSorters();
		progressWindow.setDescription("Running tests...");
		ArrayList<Long> times = new ArrayList<>();
	
		for(int i=0; i<sorters.size(); i++) {
			progressWindow.setProgress((i+1)+"/"+sorters.size());
			times.add(sorters.get(i).sort());
		}
		
		progressWindow.setDescription("Creating graph...");
		double data[][] = new double[2][sorters.size()];
		for (int i = 0; i < sorters.size(); i++) {
			data[0][i] = sorters.get(i).getThreads().size();
			data[1][i] = times.get(i);
		}
		DefaultXYDataset dataset = new DefaultXYDataset();
		dataset.addSeries(algorithmName, data);
		progressWindow.dispose();
		new LineChartWindow(dataset, "Vrijeme sortiranja u zavisnosti od broja tredova", "Thread count", "time [ms]");

	}

}
