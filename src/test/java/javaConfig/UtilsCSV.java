package javaConfig;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class UtilsCSV {
	static String CSV_PATH = System.getProperty("user.dir") + "\\resources\\logintest.csv";
	private static CSVReader csvReader;
	static String[] csvCell;
	int s = 0;

	public static Map<String, String> getCSVData(int index) throws CsvValidationException, IOException {
		csvReader = new CSVReader(new FileReader(CSV_PATH));
		csvCell = csvReader.readNext();

		for (int i = 1; csvCell != null; i++) {
			Map<String, String> dataSet = new HashMap<String, String>();
			if (index == i) {
				dataSet.put("name", csvCell[0]);
				dataSet.put("userName", csvCell[1]);
				dataSet.put("password", csvCell[2]);
				return dataSet;
			}
			csvCell = csvReader.readNext();
		}
		return null;

	}

}
