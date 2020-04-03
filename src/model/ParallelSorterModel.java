package model;

import java.util.ArrayList;

public class ParallelSorterModel {
	private ArrayList<Thread> threads;

	public ParallelSorterModel(ArrayList<Integer> array, int threadCount, int filesPerThread, String algorithmName) {
		System.out.println(
				"Creating Parallel... " + "Thread count: " + threadCount + "; Files per thread: " + filesPerThread);
		this.threads = new ArrayList<>();
		for (int i = 0; i < threadCount; i++)
			threads.add(new Thread(new SerialSorterModel(array, filesPerThread, algorithmName)));
	}

	public void sort() {
		for(Thread th:threads)
			th.start();
	}
	
}
