import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution5 {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
       // Arrays.sort(expenditure);
        int count=0;
for(int i=d;i<expenditure.length;i++)
{
    float mid=0;
    Arrays.sort(expenditure,i-d,i-1+1);
    if(d%2==0)
    {
    	
        float median=(i-d+i-1)/2;
        median=(float) Math.floor(median);
        int midian=(int)median;
        mid=(expenditure[midian]+expenditure[midian+1])/2;
    }
    else
    {
        int median=(i-d+i-1)/2;
       // System.out.println("median"+median);
        mid=expenditure[median];
    }
    
    if(expenditure[i]>=2*mid)
    {
        count++;
    }
}
return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
//System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
       bufferedWriter.newLine();

      bufferedWriter.close();

        scanner.close();
    }
}
