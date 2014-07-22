package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgos {

	/**
	 * @param args
	 */
	private static HashSet<Object> visited = new HashSet<Object>();
	
	public static void main(String[] args) {
         DirectedGraph dg = createDG2();
         DFS2(dg, "1");
         

	}
	
  /*                       1 
   *                      / \
   *                     v   v
   *                    2---->3 --->5
   *                    \    /  
   *                     v  v
   *                      4 
   * */	
   public static DirectedGraph createDG1(){
	   DirectedGraph dg = new DirectedGraph("1");
	   dg.addEdge("1", "2");
	   dg.addEdge("1", "3");
	   dg.addEdge("2", "4");
	   dg.addEdge("2", "3");
	   dg.addEdge("3", "4");
	   dg.addEdge("3", "5");
	   return dg;
   }
   
   
   /*                       1 
    *                      / \
    *                     v   v
    *                 |->2---->3 --->5
    *                 |  \    /      |
    *                 |   v  v       |
    *                 |    4         |
    *                 |--------<------   
    * */	                        
   public static DirectedGraph createDG2(){
	   DirectedGraph dg = new DirectedGraph("1");
	   dg.addEdge("1", "2");
	   dg.addEdge("1", "3");
	   dg.addEdge("2", "4");
	   dg.addEdge("2", "3");
	   dg.addEdge("3", "4");
	   dg.addEdge("3", "5");
	   dg.addEdge("5", "2");
	   return dg;
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
	
	// same as DFS except to show that object references in java created on the heaps are accessible by all functions
	public static void DFS2(DirectedGraph G, Object vertex){
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
	
	// find out if a vertex is reachable from u to v and if so print the path
	//public static boolean path(DirectedGraph G, Object u, Object v){
		
	//}
	
	

}
