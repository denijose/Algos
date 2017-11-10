package MultiThreading;

public class Counter {

	private int count;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Counter(int count){
		this.count = count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public synchronized void incrementCount(){
		this.count++;
	}
	
	public int getCount(){
		return count;
	}
}
