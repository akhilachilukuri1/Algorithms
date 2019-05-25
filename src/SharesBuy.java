
public class SharesBuy {
	public static int maxProfit(int[] prices) {
        int buyAmount=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            if(buyAmount>prices[i])
            {
                buyAmount=prices[i];
            }
            else
                if(buyAmount<prices[i])
                {
                    profit+=prices[i]-buyAmount;
                    buyAmount=prices[i];
                }
        }
        return profit;
    }
	public static void main(String []args)
	{
		int[] prices= {7,1,5,3,6,4};
		int result=maxProfit(prices);
		System.out.println(result);
	}
}
