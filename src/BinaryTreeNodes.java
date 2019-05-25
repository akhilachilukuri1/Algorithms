import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BNode 
 {
 	int data;
 	BNode left;
 	BNode right;
 }
public class BinaryTreeNodes {
	static Queue<BNode> level=new LinkedList<BNode>();
	public static void levelOrder(BNode root) {
		level.add(root);
		while(level.peek()!=null)
		{
			BNode next=level.poll();
			System.out.println(next.data);
			if(next.left!=null)
			{
				level.add(next.left);
			}
			if(next.right!=null)
			{
				level.add(next.right);
				
			}
		}
	}

	/*public static void levelOrder(Node root) {
   int h=findHeight(root);
   for(int i=1;i<=h+1;i++)
   {
	   printLevelOrder(root,i);
   }
   
 }
private static void printLevelOrder(Node root, int i) {
	if(root == null)
		return;
	if(i==1)
	{
		System.out.println(root.data+" ");
	}
	else
		if(i>1)
		{
			printLevelOrder(root.left,i-1);
			printLevelOrder(root.right,i-1);
		}
		
	}
static int height=0;
	private static int findHeight(Node root) {
		if(root==null)
			return 0;
		else
		{
			height=(root.left!=null||root.right!=null)?1+Math.max(findHeight(root.left),findHeight(root.right)):Math.max(findHeight(root.left),findHeight(root.right));
		}
		return height;
	}*/

}
