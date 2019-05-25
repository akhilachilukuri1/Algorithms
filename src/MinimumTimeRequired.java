import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution17 {

	// Complete the minTime function below.
	static long minTime(long[] machines, long goal) {
		long sum = 0;
		long counter = 1;
		while (sum != goal) {
			for (int j = 0; j < machines.length; j++) {
				if (counter % machines[j] == 0) {
					sum += 1;
				}
			}
			if (sum == goal) {
				break;
			}
			counter++;
		}
		return counter;
	}
	 	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nGoal = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nGoal[0]);

		long goal = Long.parseLong(nGoal[1]);

		long[] machines = new long[n];

		String[] machinesItems = scanner.nextLine().split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long machinesItem = Long.parseLong(machinesItems[i]);
			machines[i] = machinesItem;
		}

		long ans = minTime(machines, goal);
System.out.println(ans);
		//bufferedWriter.write(String.valueOf(ans));
		//bufferedWriter.newLine();

		//bufferedWriter.close();

		scanner.close();
	}
}
