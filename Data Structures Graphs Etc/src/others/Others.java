package com.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Others {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<ArrayList<Integer>> KLists = new ArrayList<ArrayList<Integer>>();
		KLists.add(new ArrayList<Integer>(Arrays.asList(4, 10, 15, 24, 26)));
		KLists.add(new ArrayList<Integer>(Arrays.asList(0, 9, 12, 20)));
		KLists.add(new ArrayList<Integer>(Arrays.asList(5, 18, 22, 30)));
		smallestRangeFromKLists(KLists);
	}

	
	public static void reverseLevelOrder(int[] tree){
		LinkedList<Integer> bfsQ = new LinkedList<Integer>();
		HashMap<Integer,LinkedList<Integer>> levels = new HashMap<Integer,LinkedList<Integer>>();
		int parent = -1;
		LinkedList<Integer> siblings = new LinkedList<Integer>();
		siblings.add(parent);
		levels.put(0, siblings);
		siblings = new LinkedList<Integer>();
		levels.put(1, siblings);
		int gen = 0, nextGen = 0, depth =0;
		bfsQ.add(parent);
		while(!bfsQ.isEmpty()){
			parent = bfsQ.remove();
			gen--;
			if(gen <= 0 && parent!= -1){
				gen = nextGen;
				nextGen = 0;
				depth++;
				 siblings = new LinkedList<Integer>();
				levels.put(depth+1, siblings);
			}
			siblings = levels.get(depth+1);
			for(int i=0;i<tree.length;i++){
				if(tree[i]==parent){
					bfsQ.add(i);
					siblings.add(i);
					nextGen++;
				}				
			}
			levels.put(depth+1, siblings);			
	
		}
		
		while(depth>=1){
			siblings = levels.get(depth--);
			for(int i=0; i<siblings.size();i++)
				System.out.print(siblings.get(i) + "  ");
			System.out.println();
		}
		
	}
	
	
	//You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists
	/*For example, 
	List 1: [4, 10, 15, 24, 26] 
			List 2: [0, 9, 12, 20] 
			List 3: [5, 18, 22, 30] 

			The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
	*/
	
	public static void smallestRangeFromKLists(List<ArrayList<Integer>> kLists){
		int k = kLists.size(); 		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, range = -1,prevRange = -1, listMinTakenFrom = 0, returnMinValue, returnMaxValue, prevMin = Integer.MAX_VALUE;
		ArrayList<Integer> container = new ArrayList<Integer>();
		for(int i=0;i<k;i++){
			int n = kLists.get(i).remove(0);
			if(n<min){
				min = n;
				listMinTakenFrom = i;
			}
			if(n>max)
				max = n;
			container.add(n);
		}
		returnMinValue = min;
		returnMaxValue = max;
		prevRange = max - min;	
		prevMin = min;
		while(true){			
			min = kLists.get(listMinTakenFrom).remove(0);			
			container.remove(listMinTakenFrom);
			container.add(listMinTakenFrom, min);
			for(int j=0;j<k;j++){
				if(container.get(j)<min){
					min = container.get(j);
					listMinTakenFrom = j;
				}
				if(container.get(j)>max)
					max = container.get(j);
			}
			range = max - min;	
			if(range<prevRange){
				prevRange = range;
				returnMinValue = min;
				returnMaxValue = max;
			}
			if(kLists.get(listMinTakenFrom).size()==0){
				System.out.println(min + " " + max);
				break;
			}			
	   }	
		
	}
}
