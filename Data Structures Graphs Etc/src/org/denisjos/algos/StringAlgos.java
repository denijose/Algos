package org.denisjos.algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StringAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = {"cat", "dog", "tac", "god", "act"};
		printAllAnagrams1(arr);
	

	}
	
	
	// some famous questions ->
	// 1.find the longest common substring in a set of strings
	// 2. find the longest common subsequence between 2 strings
	// 3
	
	/*Given an array of words, print all anagrams together. 
	 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, 
	 * then output may be “cat tac act dog god”.
	 * 1. using a hashTable
	 * 2. using two arrays
	 * */
	public static void printAllAnagrams1(String[] arr){
		HashMap<String,HashSet<String>> map = new HashMap<String,HashSet<String>>();
		HashSet<String> setOfSortedWords = new HashSet<String>();
		
		for(int i=0;i<arr.length;i++){
			char[] words = arr[i].toCharArray();
			Arrays.sort(words);
			if(map.containsKey(Arrays.toString(words))){
				HashSet<String> set = map.get(Arrays.toString(words));
				set.add(arr[i]);
				map.put(Arrays.toString(words),set);
			}
			else{
				HashSet<String> set =  new HashSet<String>();
				set.add(arr[i]);
				map.put(Arrays.toString(words),set);
			}
		}
		for(HashSet<String> set:map.values()){
			for(String str:set)
				System.out.print(str + " ");
				
		}
	}
	public static void printAllAnagrams2(String[] arr){
		int[] indexes = new int[arr.length];
		String[] words = new String[arr.length];
				
		for(int i=0;i<arr.length;i++){
			char[] eachWord = arr[i].toCharArray();
			//mergeSort(eachWord);
			words[i]=eachWord.toString();
		}
		Arrays.sort(words);		
	}
	
	/* A string S consisting of N characters is called properly nested if:
		S is empty;
		S has the form "(U)" where U is a properly nested string;
		S has the form "VW" where V and W are properly nested strings.
		For example, string "(()(())())" is properly nested but string "())" isn't.
		Write a function:
		class Solution { public int solution(String S); }
		that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
		For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.
		Assume that:
		N is an integer within the range [0..1,000,000];
		string S consists only of the characters "(" and/or ")".
		Complexity:
		expected worst-case time complexity is O(N);
		expected worst-case space complexity is O(1) (not counting the storage required for input arguments)
	 * */
	
	 public int isNested(String S) {
	        int count=0;
	        for(int i=0;i<S.length();i++){
	            if(count == 0 && S.charAt(i) == ')')
	               return 0;
	            if(S.charAt(i) == '(')
	                count++;
	            else if(S.charAt(i) == ')')
	               count--;
	            else
	               return 0;
	        }
	        
	        if(count == 0)
	            return 1;
	        else
	            return 0;
	    }
	 
/*Given an input string S write a function which returns true if it satisfies S = nT. Basically you have to find if a given string can be represented from a substring by iterating it “n” times. n >= 2
An example would suffice –
Function should return true if
1) S = “abab”
2) S = “abcdabcd”
3) S = “abcabcabc”
4) S = “zzxzzxzzx”
Function should return false if
1) S = “abac”
2) S = “abcdabbd”
3) S = “abcabcefg”
4) S = “zzxzzyzzx”
* */
	 
	 //create a generalized suffix tree for a string
	 // find the longest common substring in a set of string
	 //find the longes palindromic substring
	 //
	 
	 
}
