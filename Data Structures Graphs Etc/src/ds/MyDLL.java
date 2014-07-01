package ds;

public class MyDLL {

	private Node head = null;
	
	private class Node{
		Node right = null;
		Node left = null;
		int data;
		private Node(int d){
			data = d;
		}		
	}
	
	public void appendToTail(int d){
		if(head == null){
			head = new Node(d);
			return;
		}
		Node last = new Node(d);
		Node temp = head;
		while(temp.right != null)
			temp = temp.right;
		temp.right = last;
		last.left = temp;
	}
	
	public void appendToHead(int d){
		Node newHead = new Node(d);
		if(head!=null)
		  newHead.right = head;
		head = newHead;
		newHead.left = null;
	}
	
	public boolean appendNodeAfter(int afterNode, int data){
		Node newNode = new Node(data);
		Node temp = head;
		while(temp!=null){
			if(temp.data == afterNode){							
				newNode.left = temp;
				newNode.right = temp.right;
				temp.right.left = newNode;	
				temp.right = newNode;
				return true;
			}
			temp = temp.right;
		}
		return false;		
	}
	
	public boolean appendNodeBefore(int beforeNode, int data){
		Node newNode = new Node(data);
		Node temp = head;
		while(temp!=null){
			if(temp.data == beforeNode){
				newNode.left = temp.left;
				newNode.right = temp;
				temp.left.right = newNode;				
				temp.left = newNode;
				return true;
			}
			temp = temp.right;
		}
		return false;
	}
	
	public void print(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.right;
		}
	}
}
