package Graph;

import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreeTraversal {

	private static HashMap<BTNode,Integer> nodeDistanceMap = new HashMap<BTNode,Integer>();
	private static int MaxHorizontalDistance = 0;
	private static BTNode[][] TwoDArray;
	public static int HEIGHT = 0;
	
	/**
	 * @param args
	 */
	static {
		HEIGHT = 0;
	}
	
	public static void main(String[] args) {
		BTNode root = createBinaryTree();
		BFSWithLevels(root);
		
	}



	public static BTNode createBinaryTree(){
		BTNode root = new BTNode(1);
		root.isRoot = true;
		root.LChild = new BTNode(2);
		root.RChild = new BTNode(3);
		root.LChild.LChild = new BTNode(4);
		root.LChild.RChild = new BTNode(5);
		root.RChild.LChild = new BTNode(6);
		root.RChild.LChild.LChild = new BTNode(7);
		root.RChild.LChild.LChild.LChild = new BTNode(8);
		
		return root;
		/*                           1
		 *                      2          3
		 *                  4      5     6
		 *                              7
		 *                             8 
		 */ 
		
		
	}
	
	

	public static BTNode createBinaryTree2(){
		BTNode root = new BTNode(1);
		root.isRoot = true;
		root.LChild = new BTNode(2);
		root.RChild = new BTNode(3);
		root.LChild.LChild = new BTNode(4);
		root.LChild.RChild = new BTNode(5);
		
		return root;
		/*                           1
		 *                      2          3
		 *                  4      5     
		 *                              
		 *                              
		 */ 
		
		
	}
	
	public static BTNode createBST(){
		BTNode root = new BTNode(4);
		root.isRoot = true;
		root.LChild = new BTNode(2);
		root.RChild = new BTNode(6);
		root.LChild.LChild = new BTNode(1);
		root.LChild.RChild = new BTNode(3);
		
		return root;
		/*                           4
		 *                      2          6
		 *                  1      3     
		 *                              
		 *                              
		 */ 
		
		
	}
	
	public static void inorder(BTNode node){
		if(node==null)
			return;
		inorder(node.LChild);
		System.out.println(node.data);
		inorder(node.RChild);
	}
	
	public static void preorder(BTNode node){
		if(node==null)
			return;		
		System.out.println(node.data);
		preorder(node.LChild);
		preorder(node.RChild);
		
	}
	
	public static void postorder(BTNode node){
		if(node==null)
			return;
		postorder(node.LChild);		
		postorder(node.RChild);
		System.out.println(node.data);
	}
	
	public static int getHeight(BTNode node, int height){
	   if(node == null)
	    	return height;
		height++;
		if(HEIGHT < height)
			HEIGHT = height;
	    getHeight(node.LChild,height);
	    getHeight(node.RChild,height);
	    return height;
	}
	
	public static int getHeight2(BTNode node){
		   if(node == null)
		    	return 0;
		
		    int leftHeight = getHeight2(node.LChild);
		    int rightHeight = getHeight2(node.RChild);
		    
		    if(leftHeight > rightHeight)
		    	return ++leftHeight;
		    else 
		    	return ++rightHeight;
		   
		}
	
	public static void drawGraph(BTNode node,int verticalIndex){
		if(node==null)	
			return;			
		drawGraph(node.LChild,--verticalIndex);
		nodeDistanceMap.put(node, verticalIndex);
		//System.out.println(node.data+ " "+verticalIndex);
		verticalIndex++;		
		drawGraph(node.RChild,++verticalIndex);
	}
	
	public static void drawGraph2(BTNode node,int level,int index, String dir){
		if(node==null)
			return;		
		if(node.isRoot)
			TwoDArray[0][nodeDistanceMap.size()/2] = node;
					
			int shift = MaxHorizontalDistance + nodeDistanceMap.get(node);
			if(dir.equalsIgnoreCase("left"))
				shift = index - shift;
			if(dir.equalsIgnoreCase("right"))
				shift = index + shift;
			if(shift<0)
				shift = 0;
			if(!node.isRoot)
		     TwoDArray[level][shift] = node;
			++level;
			//System.out.println(level);
			drawGraph2(node.LChild,level,shift,"left");
		
	}
	
	public static void findMaxHorizontalDistance(){		
		for(BTNode node : nodeDistanceMap.keySet())
			if(MaxHorizontalDistance<Math.abs(nodeDistanceMap.get(node)))
				MaxHorizontalDistance = Math.abs(nodeDistanceMap.get(node));
	}
	
	public static void BFSWithLevels(BTNode root){
		LinkedList<BTNode> bfsQ = new LinkedList<BTNode>();
		int gen = 1, nextGen = 0, depth = 0;
		bfsQ.add(root);
		
		while(!bfsQ.isEmpty()){
			BTNode parent = bfsQ.remove();			
			gen--;
			if(gen <= 0 && parent != root){
				gen = nextGen;
				nextGen = 0;
				depth++;
			}
			System.out.println(depth + "--" + parent.data);
			if(parent.LChild!=null){
				bfsQ.add(parent.LChild);
				nextGen++;
			}
			if(parent.RChild!=null){
				bfsQ.add(parent.RChild);
				nextGen++;
			}
		}
	}
	
	public static double MaxDepth(BTNode node){
		if(node == null)
			return 0;
		else
			return 1 + Math.max(MaxDepth(node.LChild), MaxDepth(node.RChild));
	}
	
	
		
	}


