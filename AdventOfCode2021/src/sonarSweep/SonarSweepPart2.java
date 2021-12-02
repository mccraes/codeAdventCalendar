package sonarSweep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

	public class SonarSweepPart2 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try{
				
				ArrayList<String> arrayList = new ArrayList<>();

				try (BufferedReader reader = new BufferedReader(new FileReader("E:\\AdventChallenge2021\\puzzle1data.txt"))) {
				    while (reader.ready()) {
				        arrayList.add(reader.readLine());
				    }
				}
				catch (IOException e) {
				    // Handle a potential exception
				}
				
			    ArrayList<Integer> arrayListIntegers = new ArrayList<Integer>();

			    int arraySize = arrayList.size();
			    
			    // convert string array to integer
			    for(int i = 0; i < arraySize; i++) {
			       arrayListIntegers.add(Integer.parseInt(arrayList.get(i)));   
			    }

			    
			    int index1 = 0; // next index = 3, 6 and so on
			    int index2 = 1; // next index = 4, 7 and so on
			    
			    
			    int depthIncreaseCount = 0;
			    
			    
			    // print out the integer ArrayList - Test
			    while (index2 < (arraySize -2)) {
	
				    int firstMeasurementWindow = 0;
				    int secondMeasurementWindow = 0;

			    	int count = 0;
			    	int localIndex1 = index1;
			    	while (count < 3) {
			        	firstMeasurementWindow = firstMeasurementWindow + arrayListIntegers.get(localIndex1);
			        	++count;
			        	++localIndex1;
			        }
			    	count = 0;
			    	int localIndex2 = index2;
			    	while (count < 3) {
			    		secondMeasurementWindow = secondMeasurementWindow + arrayListIntegers.get(localIndex2);
			        	++count;
			        	++localIndex2;
			        }

			    	System.out.println(index1 + "  " + firstMeasurementWindow);
			    	System.out.println(index2 + "  " + secondMeasurementWindow);
			    	++index1;
			    	++index2;
			    	
					if (secondMeasurementWindow > firstMeasurementWindow) {
						System.out.println (secondMeasurementWindow + " (increased)");
						++depthIncreaseCount;
					}
					else if (secondMeasurementWindow <= firstMeasurementWindow) {
						System.out.println (secondMeasurementWindow + " (decreased)");
					}
					
				}

			    System.out.println ("Increased Depth Count = " + depthIncreaseCount);
			    	
    
			    

				
			}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			}
		}

	}
