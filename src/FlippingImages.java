
public class FlippingImages {
	public static int[][] flipAndInvertImage(int[][] A) {
        int length=A[0].length;
        int breadth=A.length;
        boolean flag=false;
        if(length%2==0)
        {
            flag=true;
        }
        for(int i=0;i<breadth;i++)
        {
            int left=0;
            int right=A.length-1;
            while(left<right)
            {
                if(flag)
                {
                   int temp=A[i][left];
                    A[i][left++]=(A[i][right]==0)?1:0;
                    A[i][right--]=(temp==0)?1:0;
                }
                else
                {
                	 int temp=A[i][left];
                     A[i][left++]=(A[i][right]==0)?1:0;
                     A[i][right--]=(temp==0)?1:0;
                }
            }
            if(!flag&&left==right)
            {
            	A[i][right]=(A[i][right]==0)?1:0;
            }
        }
        return A;
    }
	public static void main(String []args)
	{
	 int A[][]= {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
	 int result[][]=flipAndInvertImage(A);
	 for(int i=0;i<4;i++)
	 {
		 for(int j=0;j<4;j++)
		 {
			 System.out.print(result[i][j]+" ");
		 }
		 System.out.println();
	 }
	}
}
