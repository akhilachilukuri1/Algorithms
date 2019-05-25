import java.io.*;
import java.util.*;

 class Solution16 {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
Arrays.sort(a);
Arrays.sort(b);
Arrays.sort(c);
long max,max1,max2,count1=0,count2=0,count=0;
int prev1=0;
int prev2=0;
int prev=0;
for(int i=0;i<b.length;i++)
{
	if(i!=0)
	{
		prev=b[i-1];
		if(prev==b[i])
		{
			continue;
		}
	}
	 max=b[i];
	 count2=0;
	 count1=0;
	  prev1=0;
	for(int j=0;j<a.length;j++)
	{
		if(j!=0)
		{
			prev1=a[j-1];
			if(prev1==a[j])
			{
				continue;
			}
		}
		 max1=a[j];
		if(max>=max1)
		{
		count1++;
		}
		else
		{
			break;
		}
	}
	  prev2=0;
	for(int j=0;j<c.length;j++)
	{
		if(j!=0)
		{
			prev2=c[j-1];
			if(prev2==c[j])
			{
				continue;
			}
		}
		 max2=c[j];
		if(max>=max2)
		{
		count2++;
		}
		else
		{
			break;
		}
	}
	count+=count1*count2;
}
 return count;   }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);
System.out.println(ans);
        /*bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
