package ds;

import java.util.HashMap;

/* This is my singly linked list implementation
 * 
 *
 */
 
public class MySLL {

	public Node head = null; 
    public int length;
	
	public void appendToTail(int d){
		if(head == null){
			head = new Node(d);
			length++;
			return;
		}
		Node last =  new Node(d);
		Node temp = head;
		while(temp.next!=null)
			temp = temp.next;
		temp.next = last;	
		length++;
	}
	
	public void appendToHead(int d){
		Node newHead = new Node(d);
		if(head!=null)
			  newHead.next = head;
		head = newHead;
		length++;
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
	
	public int get(int index) throws Exception {
		Node temp = head;
		int i = 0;
		
		while (i != index && temp != null) {
			temp = temp.next;
			i++;
		}
		
		if (temp == null) {
			throw new Exception("index is out of range");
		}
		
		return (int) temp.data;			
	}
	
	
	
	
}
