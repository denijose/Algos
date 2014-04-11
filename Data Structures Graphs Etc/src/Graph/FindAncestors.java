package Graph;

import java.util.ArrayList;

public class FindAncestors {
	
	//public static ArrayList<String> ancestors = new ArrayList<String>();

	public static ArrayList<String> DFS(BTNode node,ArrayList<String> ancestors,String data){
		if(node==null)
			return ancestors;
		if(node.data==data)
			return ancestors;	
		if(!ancestors.isEmpty())
			if(ancestors.get(ancestors.size()-1)==data)
				return ancestors;
		ancestors.add(node.data);
		if(!(ancestors.get(ancestors.size()-1)==data))
			ancestors =	DFS(node.LChild,ancestors,data);
		
		if(!(ancestors.get(ancestors.size()-1)==data))
			ancestors = DFS(node.RChild,ancestors,data);
		
		return ancestors;
		
	}
}
