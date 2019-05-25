import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution13 {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
char arr[]=s.toCharArray();
int round=0;
long count=0;
while(round<=arr.length/2)
{
for(int i=0;i<arr.length;i++)
{
    
        if(round==0)
        {
        //System.out.println(arr[round+i]);
        count++;
        }
        else
        {
            if(i-round>=0&&i+round<arr.length)
            {
            	String s1=s.substring(i-round, i);
            	String s2=s.substring(i+1, i+round+1);
            	if(s1.equalsIgnoreCase(s2))
            	{
            		count++;
            	}
//                boolean flag=true;
//                for(int j=0;j<=round;j++)
//                {
//                    if((arr[i+j]!=arr[i-j]))
//                    {
//                        flag=false;
//                        break;
//                    }
//                }
//                if(flag)
//                count++;
            }
        }
    
}
round++;
}
return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine());
      //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);
System.out.println(result);
       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
}
