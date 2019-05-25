import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Definition for undirected graph.
 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
 
public class CloneGraph {
    UndirectedGraphNode clonenode;
    HashMap<Integer,UndirectedGraphNode> visited=new HashMap<Integer,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node==null)
		{
			return null;
		}
        return deepClone(node,visited);
        }
	private UndirectedGraphNode deepClone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> visited2) {
		
		UndirectedGraphNode cloneNode=new UndirectedGraphNode(node.label);
		
			visited.put(node.label, cloneNode);
		
		for(UndirectedGraphNode next:node.neighbors)
		{
			if(visited.get(next.label)==null)
			{
				deepClone(next,visited);
			}
			cloneNode.neighbors.add(visited.get(next.label));
		}
		return cloneNode;
	}
}