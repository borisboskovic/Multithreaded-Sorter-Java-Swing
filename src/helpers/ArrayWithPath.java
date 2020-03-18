package helpers;

import java.util.ArrayList;

public class ArrayWithPath {
	private ArrayList<Integer> array;
	private String path;

	public ArrayWithPath(ArrayList<Integer> array, String path) {
		this.array = array;
		this.path = path;
	}

	public ArrayList<Integer> getArray() {
		return array;
	}

	public String getPath() {
		return path;
	}

}