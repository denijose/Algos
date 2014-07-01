package Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortedLLtoBalBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<10;i++)
			list.add(i);
		Collections.sort(list);
		BTNode root = convertToBalBST(list.toArray(),0,list.size()-1);
		
		System.out.println(root.data);
		BinaryTreeTraversal.inorder(root);
	}
	
	public static BTNode convertToBalBST(Object[] array, int left, int right){
		if(left == right){
			BTNode child = new BTNode(array[left]);
			return child;
		}
		if(left > right)
			return null;
		
		int mid = (left + right)/2;
		BTNode parent = new BTNode(array[mid]);
		parent.LChild = convertToBalBST(array,left,mid -1);
		parent.RChild = convertToBalBST(array,mid+1,right);
		
		parent.isRoot = true;
		return parent;
	}

}
