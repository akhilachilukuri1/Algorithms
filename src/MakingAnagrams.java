import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution7 {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	char ch1[]=a.toCharArray();
    	char ch2[]=b.toCharArray();
    	Arrays.sort(ch1);
    	Arrays.sort(ch2);

int i=0,j=0;
int count=0;
while(i<ch1.length&&j<ch2.length)
{
if(ch1[i]<ch2[j])
{
	++i;
}else
	if(ch1[i]>ch2[j])
	{
		++j;
	}
	else if(ch1[i]==ch2[j])
	{
		++i;
		++j;
		++count;
	}
		

    }
return ch1.length+ch2.length-2*count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
