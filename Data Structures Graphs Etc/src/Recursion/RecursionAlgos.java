package Recursion;

import ds.Node;
import ds.MySLL;

public class RecursionAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = {"a", "b","c"};
		subSeq(str,"",0,2);
	}
		
		
	// get all subsequences of an array/string
	public static void subSeq(String[] arr, String pref, int i,int count){
		if(count==0){
			System.out.println(pref);
			return;
		}
		
		String prefix1 = pref + arr[i];
		String prefix2 = pref;
		subSeq(arr, prefix1, i+1,count-1);
		subSeq(arr,prefix2,i+1,count-1);
			
	}
	
	//get all subsequences of a particular legnth
	public static void subSeq2(String[] arr, String pref, int index, int count){
		if(count==0){
			System.out.println(pref);
			return;
		}
		
		
		for(int i=index;i<arr.length;i++){
			String prefix1 = pref + arr[i];
			subSeq2(arr, prefix1, i+1,count-1);
		}
			
	}
	
	//reverse a linked list using recursion
	public static Node reverseSLLRec(Node node, MySLL ll){
		if(node.next==null){
			ll.head = node;
			return node;
		}	
		reverseSLLRec(node.next, ll).next = node;
		return node;		
	}

}
