import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Solution10 {

    // Complete the isValid function below.
    static String isValid(String s) {
    	String result="";
HashMap<Character,Integer> values=new HashMap<Character,Integer>();
for(int i=0;i<s.length();i++)
{
	char ch=s.charAt(i);
	if(values.get(ch)!=null)
	{
		int occurance=values.get(ch);
		values.put(ch,occurance+1);
	}
	else
	{
		values.put(ch,1);
	}
}
int max=0,min=100;
for(Character ch:values.keySet())
{
	int occ=values.get(ch);
	if(occ>max)
	{
		max=occ;
	}
	else if(occ<min)
	{
		min=occ;
	}
}
int max1=0,min1=0;
for(Character ch:values.keySet())
{
	int occ=values.get(ch);
	if(occ==max)
	{
		max1=max1+1;
	}
	else if(occ==min)
	{
		min1=min1+1;
	}
}
if(values.size()!=1)
{
if(max1>min1&&min1==1&&Math.abs(max-min)==1)//(max1==1)||(min1==1))
{
	//if(max-min==1)
	result="YES";
}
else if(max1<min1&&max1==1&&Math.abs(max-min)==1)
{
	result="YES";
}
else
{
	result="NO";
}
}
else
{
	result="YES";
}
    return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
System.out.println(result);
      //  bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
