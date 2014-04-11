package ds;

public class ArrayStack {

	private int[] stack;
	private int top;
	
	public ArrayStack(int size){
		stack = new int[size];
		top = -1;
	}
	
	public void push(int item){
		if(top<stack.length)
		 stack[++top]=item;
	}
	
	public int pop(){
			return stack[top--];		
	}
	
	public boolean isEmpty(){
		if(top<0)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if(top == stack.length - 1)
			return true;
		return false;
			
	}
	
	public void display(){
		System.out.println("Stack Contents");
		for(int i =0;i<=top;i++)
			System.out.print(stack[i] + " ");
	}
}
