
public class BinaryGap {
	 public static int binaryGap(int N) {
		 int length=0;
		 int maximum=0;
		 
	      while(N!=0)
	      {
	    	  if((N&1)==0)
	    	  {
	    		 if(length>maximum) 
	    		 {
	    			 maximum=length;
	    		 }
	    		 length=1;
	    	  }
	    	  else
	    	  {
	    		  if(length>=1)
	    		  {
	    			  length++;
	    		  }
	    	  }
	    	  N=N>>1;
	      }
	      return maximum;
	    }
	    public static void main(String[] args)
	    {
	    	int result = binaryGap(22);
	    	System.out.println(result);
	    }
}
