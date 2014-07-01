package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class DirectedGraph {
    public HashSet<Object> V = new HashSet<Object>();
    public HashMap<Object,HashSet<Object>> E = new HashMap<Object,HashSet<Object>>();
    
    public DirectedGraph(Object v){ 
       V.add(v);
       E.put(v, new HashSet<Object>());
    }
    
    public DirectedGraph(HashSet<Object> V){
    	this.V = V;
    }
    
    public DirectedGraph(HashSet<Object> V, HashMap<Object,HashSet<Object>> E){
    	this.V = V;
    	this.E = E;
    }
    
    public void addEdge(Object u, Object v){
    	HashSet<Object> uEdges;
    	if(V.add(u))
    		uEdges =  new HashSet<Object>();
    	else
    		uEdges = E.get(u);
    	
    	if(V.add(v))
    		E.put(v, new HashSet<Object>());

    	uEdges.add(v);
    	E.put(u, uEdges);    	
    	
    }
    
    
	
	
}
