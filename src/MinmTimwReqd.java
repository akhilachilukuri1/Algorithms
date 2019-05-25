import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class sollu  {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
         double result =0;
    for(int i=0;i<machines.length;i++)  {
        result += ((double)1/machines[i]);

    }
    System.out.println(result);
    result = goal/result;
    System.out.println(result);

    return (long)Math.ceil(result);
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
