package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class MainProgram {

	public static void main(String[] args) throws Exception {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		List<String> symptoms = analyticsCounter.reading("symptoms.txt");

		Map mapSymptomsOccurences = analyticsCounter.count(symptoms);

		analyticsCounter.saving(mapSymptomsOccurences);

	}
}