package Graph;

public class BTAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       BTNode root = BinaryTreeTraversal.createBinaryTree();
       printAllNodesKDistanceFromRoot(root,1,0);


	}

	// Given a BST, transform it into sum tree where each node contains sum of all nodes greater than that node.
	public static int gatherSum(BTNode node, int sum){	
		
		if(node.LChild == null && node.RChild == null){
				int temp = (int)node.data;
				node.data = sum;
				return temp + sum;			
		}
		int temp = (int)node.data;
		node.data = gatherSum(node.RChild, sum);
		gatherSum(node.LChild,temp+(int)node.data);
		return (int)node.data;		
	}
	
	//Reverse the alternate level nodes of the binary tree.
	public static void reverseAlternateLevelNodes(BTNode node){
		
	}
	
	
	//print all the nodes k distance from the leaf
	public static void printAllNodesKDistanceFromLeaf(BTNode node, String path, int k){
		if(node == null)
			return;
		
		if(node.LChild == null && node.RChild == null){
			String[] array = path.split("");			
			if(array.length > k)
				System.out.println(array[array.length-k]);
			return;
		}
		
		path += node.data;
		printAllNodesKDistanceFromLeaf(node.LChild,path,k);
		printAllNodesKDistanceFromLeaf(node.RChild,path,k);
	}
	
	//print all the nodes k distance from the rot
	public static void printAllNodesKDistanceFromRoot(BTNode node, int k, int level){
		if(node==null)
			return;
		// no need to check  if a node is a leaf or not particularly
		
		if(level==k){
			System.out.println(node.data);
			return;
		}
		printAllNodesKDistanceFromRoot(node.LChild,k,++level);
		--level;
		printAllNodesKDistanceFromRoot(node.RChild,k,++level);
			
		
		
	}
}
