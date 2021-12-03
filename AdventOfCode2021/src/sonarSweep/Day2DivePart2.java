package sonarSweep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day2DivePart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			ArrayList<String> arrayList = new ArrayList<>();

			try (BufferedReader reader = new BufferedReader(new FileReader("E:\\AdventChallenge2021\\day2divedata.txt"))) {
				while (reader.ready()) {
					arrayList.add(reader.readLine());
				}
			} catch (IOException e) {
				// Handle a potential exception
			}

			int arraySize = arrayList.size();

			int directionCount = 0;
			int depth = 0;
			int aim = 0;

			for (int i = 0; i < arraySize; i++) {
				String tokens[] = arrayList.get(i).split(" ");

				System.out.println(tokens[0] + " " + tokens[1]);

				String direction = tokens[0];
				Integer directionValue = Integer.parseInt(tokens[1]);

				switch (direction) {
				case "forward":
					directionCount = directionCount + directionValue;
					depth = depth + (directionValue * aim);
					break;
				case "up":
					aim = aim - directionValue;
					break;
				case "down":
					aim = aim + directionValue;
					break;
				default:
					break;
				}

				System.out.println("direction = " + direction + " value = " + directionValue + " aim = " + aim);

			}

			System.out.println("Result = " + directionCount * depth);

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

}
