import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EvaluateDivision {
	public static Map<String,Map<String,Double>> graph=new HashMap<>();
	public static double result[];
public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	result=new double[queries.length];
	graph=constructGraph(equations,values);
	for(int i=0;i<queries.length;i++)
	{
		result[i]=calculateDistance(queries[i][0],queries[i][1],new HashSet<String>());
	}
	return result;
    }
	
private static Double calculateDistance(String from, String to, HashSet<String> hashSet) {
	if(!graph.containsKey(from))
		return -1.0;
	if(graph.get(from).containsKey(to))
	{
		return graph.get(from).get(to);
	}
	hashSet.add(from);
	for(Entry<String, Double> neighbour:graph.get(from).entrySet())
	{
		if(!hashSet.contains(neighbour.getKey()))
		{
			double miniDistance=calculateDistance(neighbour.getKey(),to,hashSet);
			if(miniDistance!=-1.0)
			{
				return neighbour.getValue()*miniDistance;
			}
		}
	}
	return -1.0;
}

private static Map<String, Map<String, Double>> constructGraph(String[][] equations, double[] values) {
	for(int i=0;i<equations.length;i++)
	{
		String from=equations[i][0];
		String to=equations[i][1];
		graph.putIfAbsent(from, new HashMap<String,Double>());
		graph.get(from).put(to, values[i]);
		graph.putIfAbsent(to, new HashMap<String,Double>());
		graph.get(to).put(from,1/values[i]);
	}
	return graph;
}
public static void main(String[] args)
{
	String [][] equation= {{"a","b"}};
	double[] values= {0.5};
	String [][] queries= {{"a","b"},{"b","a"},{"a","c"},{"x","y"}};
	System.out.println(calcEquation(equation,values,queries));
}
}

