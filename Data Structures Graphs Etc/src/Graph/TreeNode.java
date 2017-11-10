package Graph;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {
	public Set<TreeNode> connections;
	public String data;
	
	public TreeNode(String data){
		this.data = data;
		this.connections = new HashSet<TreeNode>();
	}
}
