import java.io.*;
import java.util.*;

 class Solution15 {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
Arrays.sort(arr);
int count=0;
for(int j=arr.length-1;j>=0;j--)
{
	for(int i=1;i<=j;i++)
	{
	if((arr[j]-arr[j-i])==k)
	{
		++count;
	}
	}
}
    return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
      //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);
System.out.println(result);
    //    bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
}
