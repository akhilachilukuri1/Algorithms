import java.util.*;
import java.io.*;
class MYNode1 {
    MYNode1 left;
    MYNode1 right;
    int data;
    
    MYNode1(int data) {
        this.data = data;
        left = null;
        right = null;
    }
    public String toString() {
		return "left data" + left.data + " " + "data" + data + "right data" + right.data;
	}
}


public class BinaryTreeHeight {
	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	static int height=0;
	public static int height(MYNode1 root) {
      	   if(root==null)
              {
               return 0;
          }
       else
           {
    	  height=(root.left!=null||root.right!=null)?1+Math.max(height(root.left),height(root.right)):Math.max(height(root.left),height(root.right));
               return height;
           }
    }
	public static MYNode1 insert(MYNode1 root, int data) {
        if(root == null) {
            return new MYNode1(data);
        } else {
            MYNode1 cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        MYNode1 root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}
