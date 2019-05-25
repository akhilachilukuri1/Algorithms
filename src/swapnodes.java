import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class Nodes
{
	int data,depth;
	Nodes left,right;
	Nodes(int data,int depth)
	{
		this.data = data;
		this.depth = depth;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public Nodes getLeft() {
		return left;
	}
	public void setLeft(Nodes left) {
		this.left = left;
	}
	public Nodes getRight() {
		return right;
	}
	public void setRight(Nodes right) {
		this.right = right;
	}
	
}
 class Solution22 {

	 static Nodes insertNodes(int[][] indexes)
    {
		 
		 Nodes node=new Nodes(1,1);
		 Queue<Nodes> queue=new LinkedList<Nodes>();
		 queue.offer(node);
		 Nodes current=node;
		 Nodes left=null;
		 Nodes right=null;
		 for(int j=0;j<indexes.length;j++)
	    	{
	    		System.out.println("function indexes length "+indexes);
	    			while(queue!=null)
	    			{
	    				Nodes mynode=queue.poll();
	    				System.out.println("queue node"+mynode.data);
	    				if(indexes[j][0]!=-1)
	    				{
	    					
	    				 left=new Nodes(indexes[j][0],mynode.depth+1);
	    				 System.out.println("left node"+indexes[j][0]);
	    				mynode.setLeft(left);
	    				}
	    				else
	    				{
	    					left=null;
	    					mynode.setLeft(null);
	    				}
	    				if(indexes[j][1]!=-1)
	    				{
	    				 right=new Nodes(indexes[j][1],mynode.depth+1);
	    				 System.out.println("right node"+indexes[j][1]);
	    				mynode.setRight(right);
	    				}
	    				else
	    				{
	    					right=null;
	    					mynode.setRight(null);
	    				}
	    				if(mynode.left!=null)
	    				{
	    				queue.offer(left);
	    				left=null;
	    				}
	    				if(mynode.right!=null)
	    				{
	    				queue.offer(right);
	    				right=null;
	    				}
	    			}
	    		
	    	}
		 
		return current;
    	
    }
    static void swapNodes(int[][] indexes, int[] queries) {
    	
    	Nodes root=insertNodes(indexes);
    	
        for(int i=0;i<queries.length;i++)
        {
        	swapMyNodes(root,queries[i]);
        	
        }
        inoder(root);
    }
public static void inoder(Nodes root)
{
	if(root!=null)
	{
	inoder(root.left);
	System.out.println(root.data);
	inoder(root.right);
	}
}
    private static void swapMyNodes(Nodes root, int i) {
		if(root!=null)
		{
			if(root.depth==i)
			{
				Nodes tmp=root.getLeft();
				root.left=root.getRight();
				root.right=tmp;
			}
			swapMyNodes(root.getLeft(),i);
			swapMyNodes(root.getRight(),i);
		}
		
		
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];
        System.out.println("main indexes length "+n);
        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

      swapNodes(indexes, queries);

        /*for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }*/

       // bufferedWriter.newLine();

       //ss bufferedWriter.close();
    }
}
	