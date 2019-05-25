import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedString {

	// Complete the isBalanced function below.
	static String isBalanced(String s) {
		char ch[] = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[') {
				stack.push(ch[i]);
			} else if (ch[i] == '}' || ch[i] == ')' || ch[i] == ']') {
				if(!stack.isEmpty())
				{
				char latest = stack.pop();
				if ((ch[i] == '}' && latest == '{') || (ch[i] == ')' && latest == '(')
						|| (ch[i] == ']' && latest == '[')) {

				} else {
					return "NO";
				}
				}
				else
				{
					return "NO";
				}
			}
		}
		if(!stack.isEmpty())
		{
			return "NO";
		}
		return "YES";
	}

	//private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		Scanner scanner = new Scanner(System.in);

		int t = Integer.parseInt(scanner.nextLine());
		//scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
String strarr[]=new String[t];
		for (int tItr = 0; tItr < t; tItr++) {
			String s = scanner.nextLine();

			String result = isBalanced(s);
			strarr[tItr]=result;
			//System.out.println(result);
			//bufferedWriter.write(result);
			//bufferedWriter.newLine();
		}
for(int j=0;j<t;j++)
{
	System.out.println(strarr[j]);
}
		//bufferedWriter.close();

		scanner.close();
	}
}
