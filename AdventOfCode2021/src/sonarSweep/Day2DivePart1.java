package sonarSweep;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.*;

	public class Day2DivePart1 {


			public static void main(String[] args) {
				// TODO Auto-generated method stub
				try{
					
					ArrayList<String> arrayList = new ArrayList<>();

					try (BufferedReader reader = new BufferedReader(new FileReader("E:\\AdventChallenge2021\\day2divedata.txt"))) {
					    while (reader.ready()) {
					        arrayList.add(reader.readLine());
					    }
					}
					catch (IOException e) {
					    // Handle a potential exception
					}
					
				    int arraySize = arrayList.size();

			        int directionCount = 0;
			        int depth = 0;

				    // convert string array to integer
				    for(int i = 0; i < arraySize; i++) {
				    	// arrayListIntegers.add(Integer.parseInt(arrayList.get(i)));  
				        String tokens[] = arrayList.get(i).split(" ");

				        System.out.println(tokens[0] + " " + tokens[1]);
				        
				        // Use the following if you would rather split on whitespace for tab separated data
				        // tokens = line.split("\\s+");

				        String direction = tokens[0];
				        Integer directionValue = Integer.parseInt(tokens[1]); 

				        System.out.println("direction = " + direction + " value = " + directionValue + ".");

				        switch(direction) {
				        case "forward":
				          	// code block
				        	directionCount = directionCount + directionValue;
				          	break;
				        case "up":
				        	// code block
				        	depth = depth - directionValue;
				        	break;
				        case "down":
				        	// code block
				        	depth = depth + directionValue;
				        	break;
				        default:
				        	// do nothing
				      }
				        
			        System.out.println("direction = " + directionCount + " depth = " + depth + ".");
			        
			        System.out.println("Result = " + directionCount * depth);
				        
				    }


				    

					
				}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
				}
			}

		}
