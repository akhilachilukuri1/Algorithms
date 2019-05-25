import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
class swapNode
{
	int data,level;
	swapNode left,right;
	swapNode(int data,int level)
	{
		this.data=data;
		this.level=level;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public swapNode getLeft() {
		return left;
	}
	public void setLeft(swapNode left) {
		this.left = left;
	}
	public swapNode getRight() {
		return right;
	}
	public void setRight(swapNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", level=" + level + ", left=" + left + ", right=" + right + "]";
	}
}
public class MySwapNodes {
public static void main(String args[])
{
	swapNode root=createMap();
	Scanner readlines = new Scanner(System.in);
	int queries=Integer.parseInt(readlines.nextLine());
	int queryarr[]=new int[queries];
	for(int j=0;j<queries;j++)
	{
		queryarr[j]=Integer.parseInt(readlines.nextLine());
		root=swapnode(root,queryarr[j]);
	}
	//Node afterSWAP=queries(root,queryarr);
	String str="";
	//String result=printInOrder(root,str);
	//result=result.trim();
	//System.out.println(result);
	inorder_traversal(root);
}

	

	private static String printInOrder(swapNode root,String str) {
		

		if(root!=null)
		{
		str=printInOrder(root.left,str);
		str+=root.data+" ";
		str=printInOrder(root.right,str);
		}
		//System.out.print("\b");
		return str;
	
}

	public static void inorder_traversal(swapNode root){
		Stack<swapNode> s = new Stack<swapNode>();
		s.push(root);
		swapNode tempNode = root;
		while(!s.isEmpty()){
			while(tempNode != null && tempNode.left != null){
				s.push(tempNode.left);
				tempNode = tempNode.left;
			}
			tempNode = s.pop();
			System.out.print(tempNode.data+" ");
			tempNode = tempNode.right; 
			if(tempNode != null){
				s.push(tempNode);
			}
		}
	}
		

	private static swapNode swapnode(swapNode root,int k) {
	if(root!=null)
	{
		if(root.level%k==0)
		{
			swapNode temp=root.left;
			root.left=root.right;
			root.right=temp;
		}
		swapnode(root.left,k);
		swapnode(root.right,k);
	}
	return root;
}

	private static swapNode createMap() {
		@SuppressWarnings("resource")
		Scanner readlines = new Scanner(System.in);
		int n = Integer.parseInt(readlines.nextLine());
		swapNode root = new swapNode(1, 1);
		Queue<swapNode> bfs = new LinkedList<swapNode>();
		bfs.offer(root);
		while (n != 0) {
			swapNode current = bfs.poll();
			swapNode leftnode = null;
			swapNode rightnode = null;
			String children[] = readlines.nextLine().split(" ");
			int left = Integer.parseInt(children[0]);
			int right = Integer.parseInt(children[1]);
			if (left != -1) {
				leftnode = new swapNode(Integer.parseInt(children[0]), current.level + 1);
				current.setLeft(leftnode);
				bfs.offer(leftnode);
			}
			if (right != -1) {
				rightnode = new swapNode(Integer.parseInt(children[1]), current.level + 1);
				current.setRight(rightnode);
				bfs.offer(rightnode);
			}
			n--;
		}
		return root;
	}
}
