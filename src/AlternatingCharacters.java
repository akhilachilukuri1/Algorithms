import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution8 {

    // Complete the alternatingCharacters function below.
static int alternatingCharacters(String s) {
int length=s.length();
int i=0;
char prev='.';
char pres=s.charAt(i);
String res="";
while(i<length)
{
	if(prev==pres)
	{
		if(i+1<length)
		pres=s.charAt(i+1);
	}
	else
	{
		res=res+pres;
		prev=pres;
		if(i+1<length)
		pres=s.charAt(i+1);
	}
	i++;
}
return s.length()-res.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine());
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s[]=new String[q];
        for (int qItr = 0; qItr < q; qItr++) {
        	s[qItr]= scanner.nextLine();

           
           // bufferedWriter.write(String.valueOf(result));
           // bufferedWriter.newLine();
        }
        for (int qItr = 0; qItr < q; qItr++) {
        int result = alternatingCharacters(s[qItr]);
        System.out.println(result);
        }
      //  bufferedWriter.close();

        scanner.close();
    }
}
