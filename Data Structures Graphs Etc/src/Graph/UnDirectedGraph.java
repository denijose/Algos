package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class UnDirectedGraph {
	public HashSet<Object> V = new HashSet<Object>();
	public HashMap<Object, HashSet<Object>> E = new HashMap<Object, HashSet<Object>>();
	
	public UnDirectedGraph(Object vertex){
		V.add(vertex);
		E.put(vertex, new HashSet<Object>());
	}
	
	public UnDirectedGraph(HashSet<Object> vertices){
		this.V = vertices;
	}
	
	public UnDirectedGraph(HashSet<Object> vertices, HashMap<Object, HashSet<Object>> edges){
		this.V = vertices;
		this.E = edges;
	}
	
	public void addEdge(Object u, Object v){
		HashSet<Object> edgesOfu;
		HashSet<Object> edgesOfv;
		if(V.add(u))
			edgesOfu =  new HashSet<Object>();
		else
			edgesOfu = E.get(u);
		if(V.add(v))
			edgesOfv =  new HashSet<Object>();
		else
			edgesOfv = E.get(v);
		
		edgesOfu.add(v);
		edgesOfv.add(u);
		E.put(u, edgesOfu);
		E.put(v, edgesOfv);		
	}
	
	public void addVertex(Object u){
		V.add(u);
		E.put(u, new HashSet<Object>());
	}
}
