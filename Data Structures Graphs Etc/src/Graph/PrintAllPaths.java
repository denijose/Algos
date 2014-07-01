package Graph;

import java.util.ArrayList;

public class PrintAllPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTNode root = BinaryTreeTraversal.createBinaryTree();
		
		func(root, "");

	}
	
	public static void func(BTNode node, String path){
		if(node == null)
			return;
		
		path += node.data.toString();
		
		if(node.LChild == null && node.RChild == null){
			System.out.print(path);
			System.out.println();
			return;			
		}
		
		
		func(node.LChild,path);
		func(node.RChild,path);
	}

}
