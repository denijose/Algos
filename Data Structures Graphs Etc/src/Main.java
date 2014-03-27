
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.alg.cycle.*;


public class Main {

	/**
	 * @param args
	 * @throws CycleFoundException 
	 */
	
	
	public static void main(String[] args) throws CycleFoundException {	   
       SimpleGraph<String, DefaultEdge> myGraph = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);;
       myGraph.addVertex("a");
       myGraph.addVertex("b");
       myGraph.addVertex("c");
       try{
    	   myGraph.addEdge("a", "b");
    	   myGraph.addEdge("a", "c");
       }
       catch(Exception e){
    	   e.printStackTrace();
       }
      
		
		
	  	//DAG
		DirectedAcyclicGraph<String,DefaultEdge> myDag =  new DirectedAcyclicGraph<String,DefaultEdge>(DefaultEdge.class);
	 	myDag.addVertex("a");
	 	myDag.addVertex("b");
	 	myDag.addVertex("c");
	 	try{
		myDag.addDagEdge("a", "b");
		myDag.addDagEdge("a", "c");
		myDag.addDagEdge("b", "c");
		//myDag.addDagEdge("c", "a");
	 	}
	 	  catch(Exception e){
	    	   e.printStackTrace();
	       }
	 	
	 	//detecting cycles
	 	JohnsonSimpleCycles<String,DefaultEdge> detectCycles =  new JohnsonSimpleCycles<String,DefaultEdge>();
	 	detectCycles.setGraph(myDag);
	 	
		
		  System.out.println( "Simple Graph -> " +myGraph.toString() );
		  System.out.println( "DAG -> " + myDag.toString() );
		  System.out.println( "Cycles in the graph : " + myDag.toString() + "is : " + detectCycles.findSimpleCycles());
	      System.out.println("\nAll done");
	      System.exit(0);
	      
	      

	}

}
