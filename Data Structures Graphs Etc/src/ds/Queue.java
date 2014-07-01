package ds;

public class Queue {

	Node front = null;
	Node back = null;
	
	public void enqueue(Object data){
		Node newNode = new Node(data);
		if(front == null){
			front = back = newNode;
			return;
		}
		back.next = newNode;
		back = newNode;
	}
	
	public Object dequeue(){
		Node temp = front;
		front = front.next;
		return temp;
	}
	
	public void print(){
		Node temp = front;
		while(temp!=null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
}
