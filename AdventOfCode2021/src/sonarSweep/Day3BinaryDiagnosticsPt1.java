package sonarSweep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day3BinaryDiagnosticsPt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			ArrayList<String> arrayList = new ArrayList<>();

			try (BufferedReader reader = new BufferedReader(new FileReader("E:\\AdventChallenge2021\\day3binary.txt"))) {
				while (reader.ready()) {
					arrayList.add(reader.readLine());
				}
			} catch (IOException e) {
				// Handle a potential exception
			}

			int arraySize = arrayList.size();
			
			String line = arrayList.get(0);
			int binaryDataLength = line.length();

			System.out.println("File Rows = " + arraySize);
			System.out.println("Binary Number Length = " + binaryDataLength);


			int[][] binaryData = new int[arraySize][binaryDataLength];
			
			int zeroBitCount = 0;
			int oneBitCount = 0;
			
			// The most common bit of the binary digits
			int[] gammaRate = new int[binaryDataLength];
			// The least common bit of the binary digits
			int[] epsilonRate = new int[binaryDataLength];
			
			

			// loop through all the lines of the data file
			for (int i = 0; i < arraySize; i++) {


				// loop through each character of line and count the zero's and one's
				line = arrayList.get(i);
			    System.out.println("Binary Number = " + line);

				for (int j=0; j < binaryDataLength; j++) {
				    
				    int thisChar = line.charAt(j) - '0';
				    
				    System.out.println("Char " + j + " is " + line.charAt(j));
				    
				    binaryData[i][j] = thisChar;
				    
				}
	
			}

			
			for (int j=0; j < binaryDataLength; j++) {
			    
   
				for (int i = 0; i < arraySize; i++) {

				    int thisBinaryDigit = binaryData[i][j];
				    
				    if (thisBinaryDigit == 0)
				    	++zeroBitCount;
				    else
				    	++oneBitCount;
				}
				
				System.out.println("Column " + j + " has zeroBitCount = " + zeroBitCount + " and oneBitCount = " + oneBitCount);
				
				if (zeroBitCount > oneBitCount) {
					gammaRate[j] = 0;
					epsilonRate[j] = 1;
					//System.out.println("gammaRate[" + j + "] = 0");
					//System.out.println("epsilonRate[" + j + "] = 1");

				} else {
					gammaRate[j] = 1;
					epsilonRate[j] = 0;
					//System.out.println("gammaRate[" + j + "] = 1"); 
					//System.out.println("epsilonRate[" + j + "] = 0"); 
				}
				
				zeroBitCount = 0;
				oneBitCount = 0;

			}
			
			for (int j=0; j < binaryDataLength; j++) {
				System.out.println("gammaRate[" + j + "] = " + gammaRate[j]);
			}
			
			for (int j=0; j < binaryDataLength; j++) {
				System.out.println("epsilonRate[" + j + "] = " + epsilonRate[j]);
			}

		
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}