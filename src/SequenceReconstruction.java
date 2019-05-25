import java.util.ArrayList;
import java.util.List;
class SequenceReconstruction {
	public static ArrayList<ArrayList<Integer>> mygraph;
	public static int topologicalSequence[];
	public static boolean visited[];
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    	mygraph=new ArrayList<ArrayList<Integer>>(org.length+1);
    	int count=countUniqueNodes(seqs);
    	mygraph=constructGraph(seqs);
    	topologicalSequence=new int[mygraph.size()];
    	int max=mygraph.size()-1;
    	visited=new boolean[mygraph.size()];
    	for(int i=0;i<seqs.size();i++)
    	{
    	boolean circles=checkForCircles(mygraph,i,-1,new boolean[mygraph.size()]);
    	}
    	for(int j=0;j<mygraph.size();j++)
    	{
    		max=topologicalSort(mygraph,visited,j,topologicalSequence,max);
    	}
    	if(topologicalSequence.length!=org.length)
    		return false;
    	else
    	{
    		for(int i=0;i<topologicalSequence.length-1;i++)
    		{
    			if(topologicalSequence[i]!=org[i])
    				return false;
    		}
    	}
    	return true;
    }
    
	private int countUniqueNodes(List<List<Integer>> seqs) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int topologicalSort(ArrayList<ArrayList<Integer>> mygraph2, boolean[] visited2, int start,
			int[] topologicalSequence2, int max) {
		ArrayList<Integer> adj=mygraph2.get(start);
		visited2[start]=true;
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[adj.get(i)])
			{
				max=topologicalSort(mygraph2,visited2,adj.get(i),topologicalSequence2,max);
			}
		}
		topologicalSequence2[max]=start;
		max=max-1;
		return max;
	}

	private boolean checkForCircles(ArrayList<ArrayList<Integer>> mygraph2, int start, int parent, boolean[] visited) {
		ArrayList<Integer> adjList=mygraph2.get(start);
		visited[start]=true;
		for(int neighbour:adjList)
		{
			if(visited[neighbour]&&neighbour!=parent||!visited[neighbour]&&checkForCircles(mygraph2,neighbour,start,visited))
			{
				return true;
			}
		}
		return false;
	}
	private ArrayList<ArrayList<Integer>> constructGraph(List<List<Integer>> seqs) {
	int length=seqs.size();
	for(int i=0;i<length;i++)
	{
		//mygraph.add(new ArrayList<Integer>());
		List adj=seqs.get(i);
		for(int j=0;j<adj.size();j++)
		{
			if(!mygraph.contains(adj.get(j)))
			{
				mygraph.add((int) adj.get(j),new ArrayList<Integer>());
			}
			if(adj.size()>j+1)
			mygraph.get((int)adj.get(j)).add((int)adj.get(j+1));
		}
	}
		return mygraph;
	}
	
	public static void main(String[] args)
	{
		int[] org= {1,2,3};
		int[][] edges= {{1,2},{1,3}};
		List array1=new ArrayList<Integer>();
		array1.add(1);
		array1.add(2);
	List array2=new ArrayList<Integer>();
		array2.add(1);
		array2.add(3);
		List<List> graph=new =List<List>();
		graph.add(array1);
		graph.add(array2);
		System.out.println(sequenceReconstruction(org,graph));
	}
}
