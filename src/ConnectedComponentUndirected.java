import java.util.ArrayList;

class ConnectedComponentUndirected {
    public static ArrayList<ArrayList<Integer>> mygraph;
	public static boolean visited[];
    public static int countComponents(int n, int[][] edges) {
        visited=new boolean[n];
		mygraph=new ArrayList<ArrayList<Integer>>(n);
		convertArrayIntoGraph(n,edges);
		int countComponent=0;
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				countComponent++;
			dfs(i,mygraph);
			}
		}
		return countComponent;
    }
    
    private static void dfs(int i, ArrayList<ArrayList<Integer>> mygraph2) {
		ArrayList<Integer> adj= mygraph2.get(i);
		visited[i]=true;
		for(int j=0;j<adj.size();j++)
		{
			if(!visited[adj.get(j)])
				dfs(adj.get(j),mygraph2);
				
		}
		
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
			
		}
}
	public static void main(String[] args)
	{
		int[][] edges= {{0,1},{1,2},{3,4}};
		System.out.println(countComponents(5,edges));
	}
}