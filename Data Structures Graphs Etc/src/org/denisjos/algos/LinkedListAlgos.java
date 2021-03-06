package org.denisjos.algos;

import java.util.ArrayList;
import java.util.LinkedList;

import ds.Node;
import ds.MySLL;

public class LinkedListAlgos {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		int[][] sortedLists = new int[3][4];
//		sortedLists[0] = new int[]{2,4,6,8};
//		sortedLists[1] = new int[]{1,3,5,7};
//		sortedLists[2] = new int[]{0,9,14,15};
//		sortKSortedLists(sortedLists);
		
		MySLL l1 = new MySLL();
		l1.appendToTail(1);l1.appendToTail(3);l1.appendToTail(5);l1.appendToTail(6);l1.appendToTail(8);l1.appendToTail(9);
		MySLL l2 = new MySLL();
		l2.appendToTail(1);l2.appendToTail(2);l2.appendToTail(4);l2.appendToTail(7);l2.appendToTail(7);l2.appendToTail(8);l2.appendToTail(13);
		mergeTwoMySLL(l1, l2).print();

		
		

	}
    //reverse a linked list - simple way
	public static Node reverseLinkedList(Node head){
		Node prev = null, cur = head, next = null;
		while(cur!=null){
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	// reverse a linkedlist using stack
	public static Node reverseLinkedListUsingStack(Node head){
		LinkedList<Node> stack = new LinkedList<Node>();
		Node temp = head;
		while(temp!=null){
			stack.push(temp);
			temp=temp.next;
		}
		Node ret = stack.pop();
		temp = ret;
		while(!stack.isEmpty()){
			temp.next =  stack.pop();
			temp = temp.next;
		}
		temp.next = null;
		return ret;
	}
	
	//Given a link list and input int K, reverse the link list in K size slots
	public static void reverseLLKSizeSlots(MySLL ll,int k){
		Node temp = ll.head;
		Node prev = null;
		ArrayList<Node> array = new ArrayList<Node>();
		int i =0;
		boolean flag = true;
		while(temp!=null){
			if(i==k-1){
				if(flag == true){
					ll.head = temp;
					flag = false;
				}	
				Node next = temp.next;
				if(prev != null)
				   prev.next = temp;
				i--;
				while(array.size()>0){
					temp.next = array.remove(i--);
					temp = temp.next;
				}
				prev = temp;
				temp = next;
				i=0;
			}
			else{
				array.add(temp);
				i++;
				Node next = temp.next;
				temp.next = null;
				temp = next;
			}
		}
		
	}
	
	
	// given a k sorted linked lists, produce one big list in O(nlognk)
	public static  void sortKSortedLists(int[][] sortedLists){
		int n=sortedLists[0].length;
		int k=sortedLists.length;
		int[] sortedList = new int[n*k];
		HeapNode[] heap = createHeap(sortedLists);
		int i=0;
		int size=heap.length;
		while(size>0){
			HeapNode min=delMinFromHeap(heap,size--);
			sortedList[i++]=min.data;
			int list=min.list;
			int index=min.index;
			index++;
			if(index<n){
				int data=sortedLists[list][index];
				HeapNode next= new HeapNode(list,index,data);
				insertIntoHeap(heap,next,++size);
			}
		}
		for(int j:sortedList)
			System.out.print(j + " ");
	}

	private static void insertIntoHeap(HeapNode[] heap, HeapNode next,int size) {
          heap[size-1] = next;
          int i=size-1;
          while(i>0){
        	  int parent;
        	  if(i%2==0)
        		  parent=i/2-1;
        	  else
        		  parent=i/2;
        	  if(heap[i].data<heap[parent].data){
        		  HeapNode temp = heap[i];
        		  heap[i]=heap[parent];
        		  heap[parent]=temp;
        		  i=parent;
        	  }
        	  else 
        		  break;
         }		
	}

	private static HeapNode delMinFromHeap(HeapNode[] heap,int size) {
		HeapNode retNode = heap[0];
		heap[0]=heap[size-1];
		int i=0;
	    while(2*i+1<size){
	    	int minChildIndex=2*i+1;
	    	if(2*i+2<size && heap[2*i+2].data<heap[2*i+1].data)
	    		minChildIndex=2*i+2;
	    	if(heap[i].data>heap[minChildIndex].data){
	    		HeapNode temp = heap[i];
	    		heap[i] = heap[minChildIndex];
	    		heap[minChildIndex] = temp;
	    		i=minChildIndex;
	    	}
	    	else
	    		break;
	    }
		return retNode;
	}

	private static HeapNode[] createHeap(int[][] sortedLists) {
		int k=sortedLists.length;
		HeapNode[] heap = new HeapNode[k];
		for(int i=0;i<k;i++){
			heap[i]=new HeapNode(i,0,sortedLists[i][0]);
		}
		for(int i=k/2-1;i>=0;i--){
			int j=i;
			while(2*j+1<k){
				int minChildIndex;
				if(heap[2*j+1].data<heap[2*j+2].data)
					minChildIndex=2*j+1;
				else
					minChildIndex=2*j+2;
				if(heap[j].data>heap[minChildIndex].data){
					HeapNode temp=heap[j];
					heap[j]=heap[minChildIndex];
					heap[minChildIndex]=temp;
				}
				j=minChildIndex;
			}
		}
		return heap;
	}

	//Write code to remove duplicates from an unsorted linked list without using a temp buffer
	public static void removeDupsFromUnOLL(){
		MySLL l = new MySLL();
		l.appendToHead(6);l.appendToHead(1); l.appendToHead(2); l.appendToHead(3); l.appendToHead(3); l.appendToHead(3);
		l.appendToHead(6); l.appendToHead(1);
		l.print();
		Node cur = l.head;
		Node prev;
		while(cur!=null){
			prev = cur;
			Node temp = cur.next;			
			while(temp!=null){
				if(temp.data==cur.data){
					prev.next = temp.next;
					temp = temp.next;
					continue;
				}
				prev = temp;
				temp =  temp.next;
			}
			cur = cur.next;
		}
		
		l.print();
		
		
	}
	
	// Prob 2.2
	//find the nth to last element of a singly linked list.
	/* 1. Traverse once to find length of the LL and then traverse second time
	 * 2. use recursion
	 * 3. use cur and runner pointers where runner will start n hops after current
	 * */
	public static Node NthFromLast(MySLL ll, int n){
		Node cur=ll.head, runner=ll.head;
		for(int i=0;i<n;i++)
			runner=runner.next;
		while(runner!=null){
			cur=cur.next;
			runner=runner.next;
		}
		System.out.print(cur.data);
		return cur;
	}
	//finding the nth last ele in LL using recursion
	public static int NthFromLastRec(Node node, int n){
		if(node==null)
			return 0;
		int i = NthFromLastRec(node.next,n);
		if(i==n)
			System.out.println(node.data);
		return i+1;	
	}
	
	//Prob 2.3
	//Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
	/* simply copy the data from the next node into this node and then delete the next node.*/
	
	
	/* Prob 2.4
	 * You have two numbers represented by a linked list, 
	 * where each node contains a single digit. 
	 * The digits are stored in reverse order, such that the 1�s digit is at the head of the list.
	 *  Write a function that adds the two numbers and returns the sum as a linked list.
	 * */
	public static MySLL addTwoNumbers(MySLL l1, MySLL l2){
		int i=0;
		Node node1=l1.head, node2=l2.head;
		MySLL l3 = new MySLL();
		l3.head = null;
		int carryOver=0, sum=0;
		Node curNode=null;
		while(node1!=null && node2!=null){			
			sum=(int)node1.data+(int)node2.data+carryOver;
			if(sum>9){
				carryOver=sum/10;
				sum=sum%10;								
			}
			else{
				carryOver=0;
			}
			
			if(l3.head==null){
				l3.head=new Node(sum);
				curNode=l3.head;
			}else{
				curNode.next=new Node(sum);
				curNode=curNode.next;
			}
			
			node1=node1.next;
			node2=node2.next;
		}
		
		if(node1!=null){
			curNode.next=new Node((int)carryOver+(int)node1.data);
			carryOver=0;
			node1=node1.next;
		}
		if(node2!=null){
			curNode.next=new Node((int)carryOver+(int)node2.data);
			carryOver=0;
			node2=node2.next;
		}
		curNode=curNode.next;
		curNode.next=null;
		
		l3.print();
		return l3;
	}
	
	/* Prob 2.5
	 * Given a circular linked list, implement an algorithm which 
	 * returns node at the beginning of the loop.
	 * 1. use extra memory - a hash set
	 * 2. 2 iterations - O(n2)
	 * 3. fast pointer and slow pointer sol
	 * */
	//fast and slow pointer sol
	public static void findStartOfLoop(MySLL ll){
		Node fast=ll.head, slow=ll.head;
		fast=fast.next;
		fast=fast.next;
		slow=slow.next;
		while(fast!=slow){
			fast=fast.next;
			fast=fast.next;
			slow=slow.next;
		}
		//slow and fast have met k nodes to the start of the loop
		Node temp=ll.head;
		while(temp!=slow){
			temp=temp.next;
			slow=slow.next;
		}
		System.out.println(temp.data);
		
	}
	
	/**
	 * Given two sorted LinkedLists merge them both
	 * @throws Exception 
	 * */
	public static MySLL mergeTwoMySLL(final MySLL list1, final MySLL list2) throws Exception {
		int i = 0;
		int j = 0;
		MySLL result = new MySLL();
		
		System.out.println(list1.length + " - " + list2.length);
		while (i < list1.length && j <list2.length) {
			if (list1.get(i) < list2.get(j)) {
				result.appendToTail(list1.get(i));
				i++;				
			} else {
				result.appendToTail(list2.get(j));
				j++;
			}
		}
		

		System.out.println(i + " - " + j);
		while(i < list1.length) {
			result.appendToTail(list1.get(i));
			i++;
		}
		
		while(j < list2.length) {
			result.appendToTail(list2.get(j));
			j++;
		}
		
		return result;
		
	}
	
	
}
