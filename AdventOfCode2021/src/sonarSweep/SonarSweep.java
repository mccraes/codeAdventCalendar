package sonarSweep;

import java.io.*;
public class SonarSweep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream("E:\\AdventChallenge2021\\puzzle1data.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			boolean firstLineRead = false;
			int depthIncreaseCount = 0;
			
			// store the previous line of file depth
			int lastDepth = 0;
			
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
				
				int currentDepth = Integer.parseInt (strLine);
				
				if (firstLineRead == false)
				{
					System.out.println (currentDepth + " (N/A - no previous measurement)");
					firstLineRead = true;
					lastDepth = currentDepth;
				}
				else if (currentDepth > lastDepth) {
					System.out.println (currentDepth + " (increased)");
					lastDepth = currentDepth;
					++depthIncreaseCount;
				}
				else if (currentDepth <= lastDepth) {
					System.out.println (currentDepth + " (decreased");
					lastDepth = currentDepth;
				}
				
			}
			System.out.println ("Increased Sepths = " + depthIncreaseCount);
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
		System.err.println("Error: " + e.getMessage());
		}
	}

}
