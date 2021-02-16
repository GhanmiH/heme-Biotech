package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface ISymptomReader {

	/**
	 * add symptoms in a list from a file
	 */
	List<String> getSymptoms(String fileName);

	/**
	 * count occurrences of symptoms from a list of symptoms
	 */
	TreeMap<String, Integer> getSymptomsOccurences(List<String> symptoms);

	/**
	 * write a new file from a map of symptoms
	 */
	void writeSymptomsAndOccurences(Map<String, Integer> mapSymptomsOccurences) throws IOException;
}
