package org.denisjos.algos;

import java.util.HashMap;
import java.util.LinkedList;

public class ArrayAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[]{6,6,6};
		HashMap<Character, Integer> map = new HashMap<Character,  Integer>();

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		for(int i:ll)
			System.out.print(i);
//		for(int i : a)
//			System.out.print(i + " ");
	}

	// remove duplicates from an array
	public static void removeDups(int[] arr){
		int i=0,j=0;
		for(i=0;i<arr.length;i++){
			if(arr[i]==arr[j])
				continue;
			arr[++j]=arr[i];
		}
		j++;
		while(j<arr.length)
			arr[j++]=0;
		i=0;
		while(i<arr.length)
			System.out.print(arr[i++]);
	}
	
	//check if an integer is a palindrome
	public static boolean isPalindrom(int num){
		int n=num;
		double size=0;;
		while(n>0){
			n=n/10;
			size++;
		}
		double left=size-1;
		double right=0;
		double leftPow = Math.pow(10, left);
		double rightPow = Math.pow(10,right);
		while(leftPow>=rightPow){
			leftPow = Math.pow(10,left--);
			rightPow = Math.pow(10,right++);
			if(!((int)(num/leftPow)%10 == (int)((num/rightPow)%10)))
				return false;
		}
		return true;
		
	}
	
	//reverse a number
	public static int reverse(int num){
		int rev = 0;
		while(num>0){
			rev = rev*10 + num%10;
			num = num/10;			
		}
		System.out.println(rev);
		return rev;
	}
	
	//check if an integer is a palindrome recursive way
	public static boolean isPalindromeRec(int n, double leftPow, double rightPow){
		if(leftPow<=rightPow)
			return true;
		
		if(! (     (int)  ( n/Math.pow(10, leftPow))%10 ==   (int)     (n/Math.pow(10,rightPow))%10        )         )
			return false;
		return isPalindromeRec(n, leftPow-1, rightPow+1);
	}
	
	//check if an integer is palindrom using BEAUTIFUL Recursion
	public static boolean beautifulRecIsPalin(int x, int y){
		if(x<0)
			return false;
		if(x==0)
			return true;
		if(beautifulRecIsPalin(x/10,y) && (x%10==y%10)){
			y = y/10;
			return true;
		}
		return false;
	}
	
	/*******************************Dutch national flag problem *****************************************
	Three Colours
	The problem was posed with three colours, here `0', `1' and `2'. The array is divided into four sections:

	a[1..Lo-1] zeroes (red)
	a[Lo..Mid-] ones (white)
	a[Mid..Hi] unknown
	a[Hi+1..N] twos (blue)
	The unknown region is shrunk while maintaining these conditions
	Lo := 1; Mid := 1; Hi := N;
	while Mid <= Hi do
	Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
	case a[Mid] in
	0: swap a[Lo] and a[Mid]; Lo++; Mid++
	1: Mid++
	2: swap a[Mid] and a[Hi]; Hi--
	 or 3-way Partitioning ---
	*/
	public static void dutchNationalFlagProblemFor3(int[] a){
		int index1 = 0, index2 = 0, high = a.length-1;
		while(index2<=high){
			int temp;
			switch (a[index2]){
			case 0: temp=a[index1];
			        a[index1]=a[index2];
			        a[index2]=temp;
			        index1++;
			        index2++;
				    break;
			case 1: index2++;
				    break;
			case 2: temp=a[high];
	        		a[high]=a[index2];
	        		a[index2]=temp;
	        		high--;
	        		break;
	        default: break;
			}
		}
	}
	
	////Dutch national flag problem for 4 items 0 1 2 3
	public static void dutchNationalFlagProblemFor4(int[] arr){
		int index1=0, index2=0,index3=0,high=arr.length-1;
		while(index3<=high){
			switch(arr[index3]){
			case 0:arr[index3]=arr[index1];
				   arr[index1]=0;
				   index1++;
				   index2++;
				   index3++;
				   break;
			case 1:arr[index3]=arr[index2];
				   arr[index2]=1;
				   index2++;
				   index3++;
				   break;
			case 2:index3++;
				   break;
			case 3:arr[index3]=arr[high];
				   arr[high]=3;
				   high--;
				   break;
			}
		}
		
		for(int i:arr)
			System.out.print(i + " ");
	}
	
	
	
	
	/****************************************** end of dutch national flag algo*/
	
	//Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
	// example [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60] output is 3 and 8
	public static void minLengthUnsortedArray(int[] a){
		int minIndex=0, maxIndex=0;
		int maxIndex2=0;
		boolean flag=false;
		for(int i=1;i<a.length;i++){
			if(a[i]>a[maxIndex]){
				maxIndex=i;
				continue;
			}
			else{
				if(!flag){
					int j=i-1;
					while(a[j]>a[i])
						j--;
					
					minIndex=j;
					maxIndex2=i;
					flag=true;
				}
				else{
					if(a[minIndex]>a[i])
						minIndex--;
					maxIndex=i;	
					maxIndex2=i;
				}				
			}
		}
		System.out.print(++minIndex + " " + ++maxIndex2);
	}
	
	//Find duplicates in O(n) time and O(1) extra space
	/* this is another method of finding the duplicate elements but this method can find
	 * more than two elements unlike the xor method and but this is also not restricted by the fact 
	 * that numbers vary from 1 to n
	 * */
	public static void findDuplicatesInArray(int[] a){
		for(int i=0;i<a.length;i++){
			int n = Math.abs(a[i]);
			if(a[n]>0)
				a[n]=-a[n];
			else
				System.out.println(-a[n]);
		}		
	}
	
	/*Given an array of integers, {1,0,2,0,3,0,0,4,5,6,7,0,0,0}, you have to create a new array which will be like (1,2,3,4,5,6,7,0,0,0,0,0,0,0}, without using any other temporary array.
	 * */
	public static void shiftZeroesToEnd(int[] arr){
		int first=0, second=0;
		while(arr[first]!=0)
			first++;
		if(first==arr.length){
			for(int i:arr)
				System.out.print(i + " ");
		    return;	
		}
		second=first+1;
		while( second<arr.length  && first<arr.length){
			while(second<arr.length-1 && arr[second]==0)	
			   second++;
			arr[first]=arr[second];
			arr[second]=0;
			first++;			
		}
		for(int i:arr)
			System.out.print(i + " ");
	}
	
	/*** from codility
	 * Let us consider a sequence a0, a1, . . . , an−1. The leader of this sequence is the element whose
      value occurs more than n/2
      times.
      sol - after removing a pair of elements of different values, the remaining sequence still has the same leader
      Removing pairs of different elements is not trivial, use an empty stack
      */
	public static int findLeader(int[] arr){
		LinkedList<Integer> stack = new LinkedList<Integer>();
		if(arr.length==1)
			return arr[0];
		else
			stack.push(arr[0]);
		
		for(int i=1;i<arr.length;i++){
		  if(!stack.isEmpty() && stack.peek()!=arr[i])
			  stack.pop();
		  else
			  stack.push(arr[i]);
		}
		
		int leader = -1;
		
		if(stack.isEmpty())
			return leader;
		else{
			leader=stack.pop();
			int count=0;
			for(int i=0;i<arr.length;i++){
				if(arr[i]==leader)
					count++;
			}
			if(count < (arr.length/2))
				leader = -1;
		}
		System.out.println(leader);
		return leader;
			
	}
	
	
	
	
}
