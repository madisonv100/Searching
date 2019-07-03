package cs143;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
	
	
	public static void main(String[] args) {

		ArrayList<Employee> sorted = loadEmployee("NameList.csv", 1000000);
		for (int i = 0; i < sorted.size(); i++) {
			//comment out to get rid of print out
			//System.out.println(sorted.get(i));
		}
		
		ArrayList<Employee> unsorted = new ArrayList<Employee>(sorted);
		Collections.shuffle(unsorted);
		
		  Random random = new Random();
		//String rand = Integer.toString(random.nextInt(1000000));
	   //String  rand = String.format("%010d",random.nextInt(1000000));
		//System.out.println(Searcher.linearSearch(rand, sorted));
		
		//System.out.println(Searcher.binarySearch(rand, sorted));
		
		int bTotal = 0;
		int lTotal = 0;
		for (int i = 0 ; i < 100 ; i++)
		{ 
			String  rand = String.format("%010d",random.nextInt(1000000)); 
			bTotal += Searcher.binarySearch(rand, sorted);
			lTotal += Searcher.linearSearch(rand, sorted);
		}
		int bAverage = bTotal/100;
		int lAverage = lTotal/100;
		System.out.println(" binary average : " + bAverage);
		System.out.println(" linier average : " + lAverage);
	
		// add code to perform at least 100 searches on a random ID
		// search both with the linear search and the binary search
		// compare both the total compares and average compares used to find the employee
		// for the two methods
		
		// BEFORE YOU RUN THE CODE WRITE DOWN WHAT YOU EXPECT TO HAPPEN AND WHY 
		
		
	}
	
	public static ArrayList<Employee> loadEmployee(String filename, int size)
	{
		
		BufferedReader br = null;
		FileReader fr = null;
		
		 ArrayList<Employee> employees = new  ArrayList<Employee>();
        ArrayList<String> lines = new  ArrayList<String>();
		try {

			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			br = new BufferedReader(new FileReader(filename));

			while ((line = br.readLine()) != null) 
			{
				lines.add(line);				
			}
		
			

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

			

			}
			int count = 0;
			for (int i = 0; i < size; i++) {
				
				String field[] = lines.get(count++).split(","); 
				
				
				employees.add(new Employee(field[0], field[1], field[2], String.format("%010d", i), field[3]));
				count = count % lines.size();
				
			}

		}

		return employees;
	}
	
}
