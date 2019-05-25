
public class BinaryRepBitGap {

	    public int binaryGap(int N) {
	    	int maxlength=0;
	        int length=0;
	        while(N!=0){
	            if((N&1)==1){
	                if(length>=maxlength){
	                    maxlength=length;
	                }
	                length=1;
	            }else if(length!=0){
	                length++;
	            }
	            N=N>>1;
	        }
	        return maxlength;
	}
}
