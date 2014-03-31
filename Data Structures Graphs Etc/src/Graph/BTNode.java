package Graph;

public class BTNode {
	public boolean isRoot;
	//public BTNode parent;
	public BTNode LChild, RChild;
	public String data;
	
	public BTNode(String data){
		this.data = data;
		//parent = null;
		LChild = null;
		RChild = null;
		isRoot = false;
	}
}
