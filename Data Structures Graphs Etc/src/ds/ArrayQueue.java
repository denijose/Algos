package ds;
/* 
 * implentation of a queue using an array
 */
public class ArrayQueue {

	private int[] queue;
	private int front, back;
	
	public ArrayQueue(int size){
		queue = new int[size];
		front = -1;
		back = -1;
	}
	
	public void Enqueue(int item){
		if(isEmtpy()){
			front++;
			back++;
			queue[front] =  item;
		}
		else if(isFull())
			return;
		else if(back == queue.length-1){
			back = 0;
			queue[back] = item;
		}
		else
			queue[++back] = item;
	}
	
	
	
	public int Dequeue(){
		int item = queue[front++];
		if(isEmtpy()){
			front = -1;
			back = -1;
		}
		else if(front==queue.length && back<front){
			front = -1;
		}
		else if(front == back+1)
			front = -1;
		
		return item;
	}
	
	public boolean isEmtpy(){
		if(front == -1)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if(back == front -1)
			return true;
		else if(front == 0 && back == queue.length-1)
			return true;
		return false;
	}
	
	public void Display(){
		System.out.println("\nQueue Contents");
		if(back > front){
			for(int i=front;i<=back;i++)
				System.out.print(queue[i]+ " ");
		}
		else{
			for(int i=front;i<queue.length;i++)
				System.out.print(queue[i]+ " ");
			for(int i=0;i<=back;i++)
				System.out.print(queue[i]+ " ");
		}
			
	}
}
