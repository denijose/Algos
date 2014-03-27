package Graph;
import java.util.LinkedList;

public class SortedLLtoBalBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 0;i<7;i++)
			list.add(i);
		
		BTNode root = convertToBalBST(list.toArray(),0,list.size()-1);
		
		System.out.println(root.RChild.data);
	}
	
	public static BTNode convertToBalBST(Object[] array, int left, int right){
		if(left == right){
			BTNode child = new BTNode(array[left].toString());
			return child;
		}
		if(left > right)
			return null;
		
		int mid = (left + right)/2;
		BTNode parent = new BTNode(array[mid].toString());
		parent.LChild = convertToBalBST(array,left,mid -1);
		parent.RChild = convertToBalBST(array,mid+1,right);
		
		parent.isRoot = true;
		return parent;
	}

}
