import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxRiddle{

	// Complete the riddle function below.
	static long[] riddle(long[] arr) {
		int j = 1;
		long result[] = new long[arr.length];
		while (j <= arr.length) {
			TreeSet<Long> ts=new TreeSet<Long>();
			//long temp[] = new long[arr.length];
			for (int i = 0; i < arr.length; i++) {
				long min = Integer.MAX_VALUE;
				if(i+j-1<arr.length)
				{
				for (int k = 0; k < j&&i+k<arr.length; k++) {
					if (arr[i + k] < min) {
						min = arr[i + k];
						//System.out.println("i:: "+i+"i value ::"+arr[i]+"k:: "+k+"j ::"+j);
					//	System.out.println("minimum::"+min);
					}
				}
				//System.out.println("adding in tree minimum"+min);
				ts.add(min);
				}
			}
			//Arrays.sort(temp);
			if(!ts.isEmpty())
			{
			//System.out.println("tree last is ::"+ts.last());
			result[j - 1] = ts.last();
			}
			j++;
		}
		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scanner.nextLine());
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long[] arr = new long[n];

		String[] arrItems = scanner.nextLine().split(" ");
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr[i] = arrItem;
		}

		long[] res = riddle(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.print(String.valueOf(res[i]));

			if (i != res.length - 1) {
				System.out.print(" ");
			}
		}

	//	bufferedWriter.newLine();

		//bufferedWriter.close();

		scanner.close();
	}
}
