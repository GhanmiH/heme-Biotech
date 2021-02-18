package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * read symptoms from file
	 */
	public List<String> getSymptoms(String fileName) {
		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * sort symptoms and count symptoms's occurrences
	 */
	public TreeMap<String, Integer> getSymptomsOccurences(List<String> symptoms) {

		TreeMap<String, Integer> map = new TreeMap<>();

		if (!symptoms.isEmpty()) {

			for (String symptom : symptoms) {
				map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
			}
		}
		return map;

	}

	/**
	 * write symptoms and occurrences in "result.out" file
	 */
	public void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException {

		FileWriter writer = new FileWriter("result.out");
		if (!mapSymptomsOccurences.isEmpty()) {
			mapSymptomsOccurences.forEach((symptom, occurrence) -> {
				try {
					writer.write(symptom + "=" + occurrence);
					writer.write(System.getProperty("line.separator"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();

		} else {
			writer.write("aucun symptome n'a été trouvé");
			writer.close();
		}
		System.out.println("Voir le fichier : result.out");
	}

}