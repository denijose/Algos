package ds;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayQueue queue = new ArrayQueue(5);
		
		queue.Enqueue(1);
		queue.Enqueue(2);
		queue.Enqueue(3);
		queue.Enqueue(4);
		queue.Enqueue(5);
		
		queue.Display();
		queue.Dequeue();
		queue.Display();
		queue.Enqueue(1);
		queue.Display();
		
		queue.Dequeue();
		queue.Dequeue();
		queue.Dequeue();
		queue.Dequeue();
		queue.Dequeue();
		queue.Display();
		

	}

}
