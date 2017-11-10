package ds;

import java.util.ArrayList;

public class NewDS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewDS obj1 = new NewDS();
		NewDS.setOfStacks obj2 =obj1.new setOfStacks(3);
		
		obj2.push(1);
		obj2.push(2);
		obj2.push(3);
		obj2.push(4);
		obj2.push(5);
		obj2.push(6);
		obj2.push(7);
		obj2.print();
		System.out.println(obj2.pop());
		System.out.println(obj2.pop());
//		obj2.push(2);
//		System.out.println(obj2.pop());
		
		obj2.print();

	}
	
	// Prob 3.1 Describe how you could use a single array to implement three stacks.
	
	/* Prob 3.2
	 * How would you design a stack which, in addition to push and pop, also has a 
	 * function min which returns the minimum element? Push, pop and min should all 
	 * operate in O(1) time.*/
	
	/* Prob 3.3
	 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
	 * Therefore, in real life, we would likely start a new stack when the previous stack 
	 * exceeds some threshold. Implement a data structure SetOfStacks that mimics this. 
	 * SetOfStacks should be composed of several stacks, and should create a new stack once 
	 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave 
	 * identically to a single stack (that is, pop() should return the same values as it would if there 
	 * were just a single stack). Implement a function popAt(int index) which performs a pop 
	 * operation on a specific sub-stack.
	 * */
	public class setOfStacks{
		int capacity;
		ArrayList<Node> set = new ArrayList<Node>();
		int curStack;
		int curCapacity;
		
		public setOfStacks(int capacity){ 
			this.capacity=capacity;
			curCapacity=0;
			curStack=-1;
		}
		
		public void push(int data){
			if(curCapacity!=capacity){
				if(curStack==-1){
					Node top=new Node(data);
					set.add(top);
					curStack++;
					curCapacity++;
					return;
				}
				Node top=set.get(curStack);
				Node newNode=new Node(data);
				newNode.next=top;
				top=newNode;
				set.remove(curStack);
				set.add(curStack, top);
				curCapacity++;
			}
			else{
				curStack++;
				Node newNode=new Node(data);
				set.add(newNode);
				curCapacity=1;
			}
		}
		
		public int pop(){
			Node top=set.get(curStack);
			Node temp=top;
			top=top.next;
			set.add(curStack, top);
			curCapacity--;
			if(curCapacity==0){
				curCapacity=capacity;
				curStack--;
			}
			return (int)temp.data;
		}
		
		public void print(){
			int n=curStack;
			while(n>=0){
				Node top=set.get(n);
				while(top!=null){
					System.out.print(top.data + " ");
					top=top.next;
				}
				System.out.println();
				n--;
			}
		}
		
	}
	

}
