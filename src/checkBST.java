class Node {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
        	this.data=data;
        }
     }
public class checkBST {
	boolean checkBST(Node root) {
        return checkclearBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
	
boolean checkclearBST(Node root,int min,int max) {
        if(root==null)
        	return true;
        if(root.data<min&&root.data>max)
        	return false;
        if(!checkclearBST(root.left,min,root.data-1))
        	return false;
        return checkclearBST(root.right,root.data,max);
        
       
    }
	
	 public static Node insert(Node root,int data) {
if(root==null)
{
	return new Node(data);
}
	  if(root.data<data)
	  {
		  root.left=insert(root.left,data);
	  }
	  else if(root.data>data)
	  {
		  root.right=insert(root.right,data);
	  }
	  return root;
	    }

}
