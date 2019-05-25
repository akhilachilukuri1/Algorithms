import java.util.ArrayList;

class ValidTreeGraph
{
	public static ArrayList<ArrayList<Integer>> mygraph;
	public static boolean visited[];
	public static boolean  validTree(int n, int[][] edges) {
		visited=new boolean[n];
		
		mygraph=new ArrayList<ArrayList<Integer>>(n);
		convertArrayIntoGraph(n,edges);
		boolean circleCheck=checkForCircle(mygraph);
		boolean connectedTree=checkForConnectedTree(mygraph);
		if(!circleCheck&&connectedTree)
		{
			return true;
		}
		return false;
	}
	private static boolean checkForConnectedTree(ArrayList<ArrayList<Integer>> mygraph2) {
		for(int i=0;i<visited.length;i++)
		{
			if(!visited[i])
			{
				return false;
			}
		}
		return true;
	}
	private static boolean checkForCircle(ArrayList<ArrayList<Integer>> mygraph2) {
		int start=0;
		int parent=-1;
		return recursiveCheckForCircles(mygraph,start,parent,visited);
		
	}
	
	private static boolean recursiveCheckForCircles(ArrayList<ArrayList<Integer>> mygraph2, int start, int parent,boolean visited[]) {
		ArrayList<Integer> adjList=mygraph2.get(start);
		visited[start]=true;
		for(int j=0;j<adjList.size();j++)
		{
			int newVertex=adjList.get(j);
			if(visited[newVertex]&&parent!=newVertex||(!visited[newVertex]&&recursiveCheckForCircles(mygraph2,newVertex,start,visited)))
				return true;
		}
		return false;
	}
	private static void convertArrayIntoGraph(int n, int[][] edges) {
		for(int i=0;i<n;i++)
	        mygraph.add(i,new ArrayList<Integer>());
		for(int i=0;i<edges.length;i++)
		{
			int left=edges[i][0];
			int right=edges[i][1];
			mygraph.get(left).add(right);
			mygraph.get(right).add(left);
			/*if(mygraph.get(left)!=null)
			{
				ArrayList<Integer> leftSide=mygraph.get(left);
				leftSide.add(right);
			}
			else
			{
				ArrayList<Integer> adjList=new ArrayList<Integer>();
				adjList.add(right);
				mygraph.add(left,adjList);
				
			}
			if(mygraph.get(right)!=null)
			{
				ArrayList<Integer> rightSide=mygraph.get(right);
				rightSide.add(left);
			}
			else
			{
				ArrayList<Integer> adjList=new ArrayList<Integer>();
				adjList.add(left);
				mygraph.add(right,adjList);
				
			}
				*/
		}
		
	}
	public static void main(String[] args)
	{
		int[][] edges= {{0,1},{0,2},{0,3},{1,4}};
		System.out.println(validTree(5,edges));
	}
}