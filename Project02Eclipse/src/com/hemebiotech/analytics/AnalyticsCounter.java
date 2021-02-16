package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(toString());

	/* read symptoms in a file and create a list of symptoms */

	public List<String> reading(String file) {
		return readSymptomDataFromFile.getSymptoms(file);
	}

	/*
	 * count occurrences of symptoms in a list and create a map of symptoms
	 */
	public Map<String, Integer> count(List<String> symptoms) {
		return readSymptomDataFromFile.getSymptomsOccurences(symptoms);
	}

	/**
	 * save a new file from a map of symptoms
	 * 
	 */
	public void saving(Map<String, Integer> mapSymptomsOccurences) throws Exception {
		readSymptomDataFromFile.writeSymptomsAndOccurences(mapSymptomsOccurences);
	}

}
