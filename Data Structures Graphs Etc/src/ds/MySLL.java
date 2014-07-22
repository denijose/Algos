package ds;

import java.util.HashMap;

/* This is my singly linked list implementation
 * 
 *
 */
 
public class MySLL {

	public Node head = null; 

	
	public void appendToTail(int d){
		if(head == null){
			head = new Node(d);
			return;
		}
		Node last =  new Node(d);
		Node temp = head;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = last;		
	}
	
	public void appendToHead(int d){
		Node newHead = new Node(d);
		if(head!=null)
			  newHead.next = head;
		head = newHead;
	}
	
	public void deleteNode(int d){

        
	}
	
	public void print(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
}
