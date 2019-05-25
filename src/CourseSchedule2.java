import java.util.ArrayList;
class CourseSchedule2 {
	 static ArrayList<ArrayList<Integer>> mygraph=new ArrayList<ArrayList<Integer>>();
		static boolean visited[];
		static boolean Circlevisited[];
	    public static int[] findOrder(int numCourses, int[][] prerequisites) {
	    	int topOrder[]=new int[numCourses];
	    	visited=new boolean[numCourses];
	    	Circlevisited=new boolean[numCourses];
	    	int start=0;
	    	int topSeq=numCourses-1;
	        formtheGraph(numCourses,prerequisites);
	        if(numCourses!=0&&prerequisites.length==0)
	        {
	        	int x=numCourses-1;
	             for(int i=0;i<numCourses;i++)
	             {
	            	 topOrder[i]=x;
	            	 x=x-1;
	             }
	             return topOrder;
	        }
	        boolean circlesCheck=false;
	        for(int i=0;i<Circlevisited.length;i++)
	        {
	           if(!Circlevisited[i])
	            circlesCheck=checkForCircles(mygraph,Circlevisited,i,-1);
	        }
	        boolean checkUnConnected=checkForUnConnectedGraph();
	        if(circlesCheck||checkUnConnected)
	        {
	        	topOrder=null;
	        	return topOrder; 
	        }
	        dfs(mygraph,topOrder,visited,start,topSeq);
	        return topOrder;
	    }
		private static boolean checkForUnConnectedGraph() {
			for(int size=0;size<Circlevisited.length;size++)
			{
				if(!Circlevisited[size])
				{
					return true;
				}
			}
			return false;
		}
		private static boolean checkForCircles(ArrayList<ArrayList<Integer>> mygraph2, boolean[] circlevisited2, int i,
				int j) {
			Circlevisited[i]=true;
			for(int adj:mygraph2.get(i))
			{
				if((Circlevisited[adj]&&adj!=j)||(!Circlevisited[adj]&&checkForCircles(mygraph2,circlevisited2,adj,i)))
				{
					return true;
				}
						
			}
			return false;
		}
		private static int dfs(ArrayList<ArrayList<Integer>> mygraph2, int[] topOrder, boolean[] visited, int start,
				int topSeq) {
			visited[start]=true;
			for(int adj:mygraph2.get(start))
			{
				if(!visited[adj])
				{
					topSeq=dfs(mygraph,topOrder,visited,adj,topSeq);
				}
			}
			topOrder[topSeq]=start;
			return topSeq-1;
		}
		private static void formtheGraph(int numCourses, int[][] prerequisites) {
			for(int j=0;j<numCourses;j++)
				mygraph.add(j,new ArrayList<Integer>());
			for(int i=0;i<prerequisites.length;i++)
			{
				//mygraph.get(prerequisites[i][0]).add(prerequisites[i][1]);
				mygraph.get(prerequisites[i][1]).add(prerequisites[i][0]);
			}
			
		}
	public static void main(String[] args)
	{
		int[][] edges= {{0,1}};
		System.out.println(findOrder(2,edges).toString());
	}
}