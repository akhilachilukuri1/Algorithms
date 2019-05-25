import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.naming.spi.DirStateFactory.Result;

 class Solution14 {
static HashMap<Integer,Integer> result=new HashMap<Integer,Integer>();
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	List newcost=Arrays.asList(cost);
    	Arrays.sort(cost);
    	for(int i=0;i<cost.length;i++)
    	{
    		int p1=cost[i];
    		int bandwidth=money-p1;
    		if(bandwidth<=cost[cost.length/2])
    		{
    			int end=cost.length/2;
    			for(int j=i+1;j<=end;j++)
    			{
    				if(p1+cost[j]==money)
    				{
    					int n=newcost.indexOf(cost[j]);
    					int z=newcost.indexOf(cost[i]);
    					System.out.println((n+1)+" "+(z+1));
    					result.put(n+1,z+1);
    					return;
    				}
    			}
    		}
    		else
    		{
    			int start=(cost.length/2)+1;
    			for(int j=start;j<=cost.length;j++)
    			{
    				if(p1+cost[j]==money)
    				{
    					int n=newcost.indexOf(cost[j]);
    					int z=newcost.indexOf(cost[i]);
    					System.out.println((n+1)+" "+(z+1));
    					result.put(n+1,z+1);
    					return;
    				}
    			}
    		}
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = Integer.parseInt(scanner.nextLine());
      //   scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = Integer.parseInt(scanner.nextLine());
         //   scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = Integer.parseInt(scanner.nextLine());
         //   scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
           // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }
Set<Integer> keys=result.keySet();
for(int key:keys)
{
	System.out.println(key+" "+result.get(key));
}
        scanner.close();
    }
}
