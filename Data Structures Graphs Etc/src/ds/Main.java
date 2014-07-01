package ds;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.dequeue();q.dequeue();
		q.print();

	}

}
