
public class Base7Rep {
	 static String result="";
	    public static String convertToBase7(int num) {
	        findLCM(num);
	        if(num<0)
	        {
	        	result=result+"-";
	        }
	        return new StringBuilder(result).reverse().toString();
	    }
	    public static String findLCM(int num)
	    {
	    	if(num==0)
	    	{
	    		return "";
	    	}
	       else{
	            int rem=num%7;
	            result=result+Math.abs(rem);
	            num=num/7;
	            findLCM(num);
	       }
	        return result;
	    }
	    public static void main(String []args)
	    {
	    	System.out.println(convertToBase7(-7));
	    }
}
