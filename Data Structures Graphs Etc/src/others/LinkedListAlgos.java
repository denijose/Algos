package others;

import java.util.ArrayList;

import ds.Node;
import ds.MySLL;

public class LinkedListAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySLL ll = new MySLL();
		ll.appendToHead(12);
		ll.appendToTail(13);
		ll.appendToTail(3);
		ll.appendToTail(20);
		ll.appendToTail(55);
		ll.appendToTail(87);
		ll.appendToTail(20);
		ll.appendToTail(77);
		ll.appendToTail(90);
		ll.print();
		reverseLLKSizeSlots(ll, 3);
		System.out.println();
		ll.print();
		

	}
	
	//Given a link list and input int K, reverse the link list in K size slots
	public static void reverseLLKSizeSlots(MySLL ll,int k){
		Node temp = ll.head;
		Node prev = null;
		ArrayList<Node> array = new ArrayList<Node>();
		int i =0;
		boolean flag = true;
		while(temp!=null){
			if(i==k-1){
				if(flag == true){
					ll.head = temp;
					flag = false;
				}	
				Node next = temp.next;
				if(prev != null)
				   prev.next = temp;
				i--;
				while(array.size()>0){
					temp.next = array.remove(i--);
					temp = temp.next;
				}
				prev = temp;
				temp = next;
				i=0;
			}
			else{
				array.add(temp);
				i++;
				Node next = temp.next;
				temp.next = null;
				temp = next;
			}
		}
		
	}

}
