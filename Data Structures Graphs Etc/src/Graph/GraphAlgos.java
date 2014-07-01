package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
     System.out.println(func(6));

	}
	
	static int func(int n) {
	    if (n==1) return 0;
	    if (n==2) return 1;
	    else return func(n-1) + func(n-2);
	}


	public static void BFS(DirectedGraph G, Object startVertex){
		HashSet<Object> visited = new HashSet<Object>();
		LinkedList<Object> bfsQ = new LinkedList<Object>();
		bfsQ.add(startVertex);
		
		while(!bfsQ.isEmpty()){
			Object u = bfsQ.remove();
			if(visited.contains(u))
				continue;
			visited.add(u);
			System.out.println(u);
			HashSet<Object> edges = G.E.get(u);
			for(Object v : edges)
				bfsQ.add(v);						
		}		
	}
	
	public static void DFS(DirectedGraph G, Object vertex, HashSet<Object> visited){
		if(vertex == null)
			return;
		System.out.println(vertex);
		visited.add(vertex);
		HashSet<Object> edges = G.E.get(vertex);
		for(Object v : edges){
			if(!visited.contains(v)){				
				visited.add(v);
				DFS(G,v,visited);
			}				
		}		
	}
	
	
	public static boolean isCyclic(DirectedGraph G, Object vertex, HashSet<Object> visited, HashSet<Object> recSet){
		visited.add(vertex);
		recSet.add(vertex);
		HashSet<Object> edges = G.E.get(vertex);
		for(Object v : edges){
			if(!visited.contains(v)){				
				visited.add(v);
				isCyclic(G,v,visited, recSet);
			}
			if(recSet.contains(v))
				return true;
		}
		recSet.remove(vertex);
		return false;
	}

}
