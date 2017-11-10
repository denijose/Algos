package MultiThreading;

public class MyRunnable implements Runnable {

	public Counter counter;
	public String name;
	
	public static void main(String[] args) {
		Counter counter = new Counter(0);
		MyRunnable myRunnable1 = new MyRunnable("Thread1",counter);
		MyRunnable myRunnable2 = new MyRunnable("Thread2",counter);
		Thread thread1 = new Thread(myRunnable1);
		Thread thread2 = new Thread(myRunnable2);
		thread1.start();
		thread2.start();

	}

	public MyRunnable(String name, Counter counter){
		this.name = name;
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			counter.incrementCount();
			System.out.println(getName() + " setting the count to " + counter.getCount() );
		}
	}
	
	public String getName(){
		return this.name;
	}

}
