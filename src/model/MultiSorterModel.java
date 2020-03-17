package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jfree.data.xy.DefaultXYDataset;

import algorithm.SortingAlgorithm;
import global.Algorithms;
import view.LineChartWindow;
import view.ObserverInterface;

public class MultiSorterModel implements SubjectInterface, Runnable {

	private ArrayList<ObserverInterface> observers;

	private String algorithmName = "";
	private ArrayList<PathSectionModel> pathModels = null;

	public MultiSorterModel() {
		this.pathModels = new ArrayList<>();
		this.observers = new ArrayList<>();
	}

	public ArrayList<PathSectionModel> getPathModels() {
		return pathModels;
	}

	public void addFiles(File[] files) {
		for (File f : files) {
			Boolean repeated = false;
			for (PathSectionModel model : pathModels) {
				if (model.getPath().equals(f.toString()))
					repeated = true;
			}
			if (!repeated)
				pathModels.add(new PathSectionModel(pathModels.size() + 1, f.toString()));
		}
	}

	public void removeAllFiles() {
		pathModels = new ArrayList<>();
	}

	public void removeFile(PathSectionModel modelToRemove) {
		// Nemoguce je prolaziti kroz listu ovakvog tipa i u isto vrijeme uklanjati
		// elemente iz liste.
		// Zbog toga je potrebno napraviti kopiju.
		ArrayList<PathSectionModel> temp = new ArrayList<>();

		for (PathSectionModel model : pathModels)
			if (!modelToRemove.equals(model))
				temp.add(model);

		pathModels = new ArrayList<>();
		for (int i = 0; i < temp.size(); i++) {
			pathModels.add(new PathSectionModel(i + 1, temp.get(i).getPath()));
		}
	}

	@Override
	public void addObserver(ObserverInterface observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(ObserverInterface observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (ObserverInterface o : observers)
			o.update();
	}

	@Override
	public void run() {
		ArrayList<ArrayList<Integer>> arraysCollection = new ArrayList<>();

		// Reading from files
		for (PathSectionModel sectionModel : pathModels) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(sectionModel.getPath()));
				Pattern pattern = Pattern.compile("\\d+");
				ArrayList<Integer> array = new ArrayList<>();
				while (in.ready()) {
					Matcher matcher = pattern.matcher(in.readLine());
					while (matcher.find()) {
						array.add(Integer.valueOf(matcher.group()));
					}
				}
				in.close();
				arraysCollection.add(array);
			} catch (FileNotFoundException e) {
				sectionModel.setMessage("ERROR! File not found."); // TODO: Lokalizacija
				sectionModel.updateView();
			} catch (IOException e) {
				sectionModel.setMessage("ERROR! Acces Denied."); // TODO: Lokalizacija
				sectionModel.updateView();
			}
		}

		// Ordering arrays by size
		arraysCollection.sort(Comparator.comparing(ArrayList::size));

		// Creating sorters
		ArrayList<SortingAlgorithm> algorithms = new ArrayList<>();
		for (ArrayList<Integer> array : arraysCollection) {
			algorithms.add(Algorithms.getInstance().createAlgorithm(algorithmName, array));
		}

		// Sorting and geting results
		ArrayList<Integer> ammounts = new ArrayList<>();
		ArrayList<Long> times = new ArrayList<>();
		for (SortingAlgorithm algorithm : algorithms) {
			times.add(algorithm.sort(null));
			ammounts.add(algorithm.getArray().size());
		}
		double[][] results = new double[2][ammounts.size()];
		for (int i = 0; i < ammounts.size(); i++) {
			results[0][i] = ammounts.get(i);
			results[1][i] = times.get(i);
		}

		DefaultXYDataset dataset = new DefaultXYDataset();
		dataset.addSeries(algorithmName, results);
		new LineChartWindow(dataset, "Vrijeme sortiranja u zavisnosti od kolièine podataka", "Kolièina podataka",
				"Vrijeme [ms]"); // TODO: Lokalizacija
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
}
