import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CommonChils {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
HashMap<Character,Integer> word1=new HashMap<Character,Integer>();
HashMap<Character,Integer> word2=new HashMap<Character,Integer>();
ArrayList<Character> common=new ArrayList<Character>();
for(int i=0;i<s1.length();i++)
{
	if(word1.get(s1.charAt(i))!=null)
	{
		word1.put(s1.charAt(i), word1.get(s1.charAt(i))+1);
	}else
	{
		word1.put(s1.charAt(i), 1);
	}
}
for(int i=0;i<s2.length();i++)
{
	if(word2.get(s2.charAt(i))!=null)
	{
		word2.put(s2.charAt(i), word2.get(s2.charAt(i))+1);
	}else
	{
		word2.put(s2.charAt(i), 1);
	}
}
Set <Character> keys=word1.keySet();
String sequen="";
for(char ch:keys)
{
	if(word2.containsKey(ch))
	{
		//sequen=sequen+"ch";
		common.add(ch);
	}
}
//common.to
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
