package Graph;

import java.util.HashMap;

public class BinaryTreeTraversal {

	private static HashMap<BTNode,Integer> nodeDistanceMap = new HashMap<BTNode,Integer>();
	private static int MaxHorizontalDistance = 0;
	private static BTNode[][] TwoDArray;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTNode root = createBinaryTree();
		//inorder(root);
		//preorder(root);
		//postorder(root);
		drawGraph(root,1);
		findMaxHorizontalDistance();
		TwoDArray = new BTNode[nodeDistanceMap.size()][nodeDistanceMap.size()];
		drawGraph2(root,0,0,"");
		for(int i =0;i<nodeDistanceMap.size();i++){
			for(int j=0;j<nodeDistanceMap.size();j++){				
				if(TwoDArray[i][j]!=null)
				  System.out.print(TwoDArray[i][j].data);
				else
				  System.out.print(" ");
			}	
			System.out.println();
		}	
	}



	public static BTNode createBinaryTree(){
		BTNode root = new BTNode("1");
		root.isRoot = true;
		root.LChild = new BTNode("2");
		root.RChild = new BTNode("3");
		root.LChild.LChild = new BTNode("4");
		root.LChild.RChild = new BTNode("5");
		root.RChild.LChild = new BTNode("6");
		root.RChild.LChild.LChild = new BTNode("7");
		root.RChild.LChild.LChild.LChild = new BTNode("8");
		
		return root;
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

}
