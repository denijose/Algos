package Graph;

public class BTNode {
	public boolean isRoot;
	//public BTNode parent;
	public BTNode LChild, RChild;
	public int data;
	
	public BTNode(int data){
		this.data = data;
		//parent = null;
		LChild = null;
		RChild = null;
		isRoot = false;
	}
}
