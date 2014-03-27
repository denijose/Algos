package Graph;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {
	public Set<TreeNode> children;
	public boolean isRoot;
	public TreeNode parent;
	public String data;
	
	public TreeNode(String data, boolean isRoot){
		this.data = data;
		this.parent = null;
		this.children = new HashSet<TreeNode>();
		this.isRoot = isRoot;
	}
}
