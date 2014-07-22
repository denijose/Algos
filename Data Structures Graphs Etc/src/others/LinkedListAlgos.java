package others;

import java.util.ArrayList;

import ds.Node;
import ds.MySLL;

public class LinkedListAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] sortedLists = new int[3][4];
//		sortedLists[0] = new int[]{2,4,6,8};
//		sortedLists[1] = new int[]{1,3,5,7};
//		sortedLists[2] = new int[]{0,9,14,15};
//		sortKSortedLists(sortedLists);
		
		MySLL l = new MySLL();
		l.appendToHead(6);l.appendToHead(1); l.appendToHead(2); l.appendToHead(3); l.appendToHead(3); l.appendToHead(3);
		l.appendToHead(6); l.appendToHead(1);
		l.print();
		NthFromLast(l, 9);
		

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
	
	//find the nth to last element of a singly linked list.
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
}
