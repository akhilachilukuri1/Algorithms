
public class AddStringSum {
	  public static String addStrings(String num1, String num2) {
	        int num1Length=num1.length()-1;
	        int num2Length=num2.length()-1;
	        int carry=0;
	        int sum=0;
	        StringBuilder str=new StringBuilder();
	        while(num1Length>=0||num2Length>=0||sum==1)
	        {
	           // sum=carry;
	            sum+=(num1Length<0)?0:num1.charAt(num1Length--)-'0';
	            sum+=(num2Length<0)?0:num2.charAt(num2Length--)-'0';
	            str.append(sum%10);
	            sum=sum/10;
	            
	        }
	        return str.reverse().toString();
	    }
	  public static void main(String args[])
	  {
		  String result=addStrings("1234","2341");
		  System.out.println(result);
	  }
}
