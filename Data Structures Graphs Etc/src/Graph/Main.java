package Graph;

import java.util.HashSet;
import java.util.Set;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode("root", true);
		TreeNode LChild = new TreeNode("1", false);
		TreeNode Rchild = new TreeNode("2", false);
		root.children.add(LChild);
		LChild.parent = root;
		root.children.add(Rchild);
		Rchild.parent = root;
		TreeNode three = new TreeNode("3", false);
		TreeNode four = new TreeNode("4", false);
		Rchild.children.add(three);
		Rchild.children.add(four);
		
		//traversal
		Set<TreeNode> visited = new HashSet<TreeNode>();
		DFS(root);

	}
	
	public static void DFS(TreeNode node){
		if(node == null)
			return;
		for(TreeNode temp : node.children){
			DFS(temp);
		}
		System.out.println(node.data);
	}

}
