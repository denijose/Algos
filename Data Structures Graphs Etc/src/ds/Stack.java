package ds;

// stack implementation using Node

public class Stack {
	Node top = null;
	
	public void push(Object data){
		Node newNode = new Node(data);
		if(top == null){			
			top = newNode;
			return;
		}
		newNode.next = top;
		top = newNode;
	}
	
	public Node pop(){
		Node temp = top;
		top = top.next;
		return temp;
	}
	
	public void print(){
		Node temp = top;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
