package libraries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class Util_CSV {

	
	
	public static ArrayList<String[]> readCSV(String filePath) throws IOException {

		CSVReader reader;
		ArrayList<String[]> arr = new ArrayList<String[]>();
		
		try {
			reader = new CSVReader(new FileReader(filePath));
			String[] nextLine;

				while ((nextLine = reader.readNext()) != null) {
					arr.add(nextLine);	
					
				}

		} catch (FileNotFoundException e) {		e.printStackTrace();   }
		
		// for info---------------------
		
		System.out.println(arr);
		return arr;
	}
}
