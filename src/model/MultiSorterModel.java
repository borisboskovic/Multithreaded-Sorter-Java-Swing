package model;

import java.io.File;
import java.util.ArrayList;

import algorithm.SortingAlgorithm;
import view.ObserverInterface;

public class MultiSorterModel implements SubjectInterface {

	private ArrayList<ObserverInterface> observers;

	private SortingAlgorithm algorithm;
	private ArrayList<PathSectionModel> pathModels = null;

	public MultiSorterModel() {
		this.pathModels = new ArrayList<>();
		this.observers = new ArrayList<>();
		pathModels.add(new PathSectionModel(1, "Boris Boskovic"));
	}

	public ArrayList<PathSectionModel> getPathModels() {
		return pathModels;
	}

	public void addFiles(File[] files) {
		for(File f : files) {
			Boolean repeated = false;
			for(PathSectionModel model : pathModels) {
				if(model.getPath().equals(f.toString()))
					repeated=true;
			}
			if(!repeated)
				pathModels.add(new PathSectionModel(pathModels.size()+1, f.toString()));
		}
	}

	public void removeAllFiles() {
		pathModels=new ArrayList<>();
	}
	
	public void removeFile(PathSectionModel modelToRemove) {
		//Nemoguce je prolaziti kroz listu ovakvog tipa i u isto vrijeme uklanjati elemente iz liste.
		//Zbog toga je potrebno napraviti kopiju.
		ArrayList<PathSectionModel> temp=new ArrayList<>();
		
		for(PathSectionModel model : pathModels)
			if(!modelToRemove.equals(model))
				temp.add(model);
		
		pathModels=new ArrayList<>();
		for(int i=0; i<temp.size(); i++) {
			pathModels.add(new PathSectionModel(i+1, temp.get(i).getPath()));
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
		for(ObserverInterface o : observers)
			o.update();
	}
}
