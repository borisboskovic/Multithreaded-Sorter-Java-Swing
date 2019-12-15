/**
 * Klasa posjeduje metode za generisanje zadate kolicine brojeva u zadatom opsegu,
 * te njihovo zapisivanje na datoj lokaciji.
 * 
 * @author Boris Boskovic
 */

package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class GeneratorModel {
	private String location;
	private int ammount;
	private int from;
	private int to;
	private String message;

	public GeneratorModel() {
		this.message = "Test 123 Ovdje ce biti ispisana neka poruka u slucaju greske!";
	}

	/**
	 * Metoda prvo provjerava da li postoje folder i fajl sa zadate lokacije i
	 * kreira ih ukoliko je potrebno. Dalje metoda generise brojeve u datom opsegu i
	 * zapisuje fajl na datoj lokaciji.
	 */
	public void generate() {
		// Kreriranje foldera i fajla
		Path filePath = Paths.get(location);
		File dir = Paths.get(filePath.getRoot().toString(), filePath.subpath(0, filePath.getNameCount() - 1).toString())
				.toFile();
		if (!filePath.toFile().exists()) {
			try {
				Files.createDirectories(dir.toPath());
				Files.createFile(filePath);
			} catch (IOException e) {
				// TODO: Lokalizacija
				this.message = "Greska! Pristup fajl sistemu trenutno nije moguc. Pokusajte sa drugom lokacijom ili pokrenite aplikaciju kao administrator";
			}
		}
		// Generisanje brojeva
		if (message.equals("")) {
			ArrayList<Integer> numbers = new ArrayList<>();
			Random rand = new Random(System.currentTimeMillis());
			for (int i = 0; i < ammount; i++) {
				int num = rand.nextInt(to + 1 - from);
				num += from;
				numbers.add(num);
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(filePath.toFile()));
				for(Integer i : numbers) {
					out.write(i+", ");
				}
				out.close();
			} catch (IOException e) {
				this.message = "Greska! Pristup fajl sistemu trenutno nije moguc. Pokusajte sa drugom lokacijom ili pokrenite aplikaciju kao administrator";
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda provjerava ispravnost zadatih parametara
	 * 
	 * @return true ukoliko su parametri ispravni
	 */
	public Boolean validate() {
		// TODO: Uraditi validaciju parametara
		return true;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}
	
}
