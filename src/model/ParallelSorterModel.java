package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParallelSorterModel {

	private ArrayList<SerialSorterModel> serialSorters;

	public ParallelSorterModel(String path, int threadCount, int filesPerThread) {
		ArrayList<Integer> array = new ArrayList<>();

		try {
			// Reading file
			BufferedReader in = new BufferedReader(new FileReader(path));
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher;
			while (in.ready()) {
				matcher = pattern.matcher(in.readLine());
				while (matcher.find())
					array.add(Integer.valueOf(matcher.group()));
			}
			in.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		serialSorters = new ArrayList<>();

	}

}
