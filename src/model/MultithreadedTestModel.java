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

	public void sort(String path) {
		readDataFromFile(path);

		System.out.println(array.get(0));
		System.out.println(array.get(array.size() - 1));
	}

	public void setView(MultithreadedTestView view) {
		this.view = view;
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
