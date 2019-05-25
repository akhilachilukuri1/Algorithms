
public class ArrangeCoins {
	public int arrangeCoins(int n) {
        int currsum=0;
        int presum=0;
        int i=0;
       while(currsum<n)
       {
          i=i+1;
         currsum+=i;
              if(currsum>n)
                  return i-1;
                     if(currsum==n)
                         return i;
           
       }
        
        return i;
    }
	public static void main(String []args)
	{
		int arrangeCoins(2147483647);
	}
}
