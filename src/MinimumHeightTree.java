import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTree {
	public static ArrayList<HashSet<Integer>> mygraph;
	public static boolean visited[];
	public static ArrayList<Integer> oldLeaves=new ArrayList<Integer>();
	public static ArrayList<Integer> newLeaves;//=new ArrayList<Integer>();
public static List<Integer>  findMinHeightTrees(int n, int[][] edges) {
	visited=new boolean[n];
	mygraph=new ArrayList<HashSet<Integer>>(n);
	convertArrayIntoGraph(n,edges);
	getOldLeaves();
	getNewLeaves(n);
	return oldLeaves;
    }
private static void getNewLeaves(int n) {
	 while (n > 2) {
	        n -= oldLeaves.size();
	        newLeaves=new ArrayList<Integer>();
	for(int i=0;i<oldLeaves.size();i++)
	{
		int newVertex=mygraph.get(oldLeaves.get(i)).iterator().next();
		mygraph.get(newVertex).remove(oldLeaves.get(i));
		if(mygraph.get(newVertex).size()==1)
			newLeaves.add(newVertex);
	}
	oldLeaves = newLeaves;
	 }
	
}
private static void getOldLeaves() {
	
	for(int i=0;i<mygraph.size();i++)
	{
		if(mygraph.get(i).size()==1)
		{
			oldLeaves.add(i);
		}
	}
}
private static void convertArrayIntoGraph(int n, int[][] edges) {
	for(int i=0;i<n;i++)
        mygraph.add(new HashSet<Integer>());
	for(int i=0;i<edges.length;i++)
	{
		int left=edges[i][0];
		int right=edges[i][1];
		mygraph.get(left).add(right);
		mygraph.get(right).add(left);


	}
	
}
public static void main(String[] args)
{
	int[][] edges= {{0,1},{0,2}};//{{3,0},{3,1},{3,2},{3,4},{5,4}};
	System.out.println(findMinHeightTrees(3,edges));
}
}
