import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class countTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	int count=0;
for(int i=0;i<arr.size()-2;i++)
{
	for(int j=i+1;j<arr.size()-1;j++)
	{
		for(int k=j+1;k<arr.size();k++)
		{
			if((arr.get(j)==arr.get(i)*r)&&(arr.get(k)==arr.get(j)*r))
					{
				count++;
					}
		}
	}
}
return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
