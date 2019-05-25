 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class ClosestBinary {
	static double minValue=Double.MAX_VALUE;
    static int val=0;
    public static int closestValue(TreeNode root, double target) {
        //int rounded=Math.round(target);
       if(root!=null)
        {
        double currentValue=Math.abs(target-root.val);
        if(currentValue<minValue)
        {
            val=root.val;
            minValue=currentValue;
        }
        if(root.val>target)
        {
            val=closestValue(root.left,target);
        }
        else if (root.val<target)
        {
              val=closestValue(root.right,target);
        }
    }
       
            return val;
}
    public static void main(String[] args)
    {
    	System.out.println(closestValue(new TreeNode(1),4.428571));
    }
   
}
