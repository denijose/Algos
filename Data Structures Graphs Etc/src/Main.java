
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph.CycleFoundException;
import org.jgrapht.alg.cycle.*;

import ds.Node;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws CycleFoundException 
	 */
	
	public static void main(String[] args) throws IOException{
		
//		final Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();        
//        
//        while (t >0) {
//        	int noOfWords = scanner.nextInt();
//            String[] dictionary = new String[noOfWords];
//            for (int i=0; i< noOfWords; i++) {
//            	dictionary[i] = scanner.next();
//            }
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            String [][] boggle = new String[n][m];
//            for (int i=0; i<(n); i++) {
//            	for(int j=0; j<m; j++){
//            		boggle[i][j] = scanner.next();
//            	}
//            }
//            printWords(dictionary, boggle);
//        	t--;
//        }	
	}
	
	
	
	public static void printWords(final String[] dictionary, final String[][] boggle) {
		for (int i=0; i< dictionary.length; i++) {
			String word = dictionary[0];
			if (wordExists(word, boggle)) {
				System.out.print(word + " ");
			}
		}
	}
	
	public static boolean wordExists(final String word, final String[][] boggle) {
		int index = 1;
		HashSet<Position<Integer, Integer>> visited = new HashSet<Position<Integer,Integer>>();
		final Position pos = findPosition(String.valueOf(word.charAt(0)));
		visited.add(pos);
		while (index < word.length()) {
			pos = findPosition(String.valueOf(word.charAt(0)));
			index++;
		}
		
		if (index == word.length() - 1)
			return true;
		return false;
	}
	
	public static class Position<First, Second> {
		private First first;
		private Second second;
		
		Position(final First first, final Second second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static boolean ifAdjacentInBoggle(int x1, int y1, int x2, int y2) {
		if ((x1 == x2-1 || x2 == x1-1 || x2 == x1) && (y1 == y2 || y1 == y2-1 || y2 == y1 -1)) {
			return true;
		}
		
		return false;
	}
	
	public static int findx(final String character, final String[][] boggle) {
		for (int i=0; i<boggle.length; i++) {
			for (int j=0; j<boggle[0].length; j++) {
				if (character.equalsIgnoreCase(boggle[i][j]))
					return i;
			}
		}
		return -1;
	}
	
	public static int findy(final String character, final String[][] boggle) {
		for (int i=0; i<boggle.length; i++) {
			for (int j=0; j<boggle[0].length; j++) {
				if (character.equalsIgnoreCase(boggle[i][j]))
					return j;
			}
		}
		return -1;
	}
	
	
	public static boolean existsInBoggle(int x, int y, final String[][] boggle) {
		final int rows = boggle.length;
		final int cols = boggle[0].length;
		
		System.out.println("rows = " + rows + " cols = " + cols);
		
		return (0 <= x && x <= rows - 1) && (0 <= y && y <= cols - 1);
	}
	
	//finding two non repeating numbers 
	public static void nonRepeatingNumbersInArray(int[] arr1, int[] arr2){
		int xor=arr1[0];
		for(int i=1;i<arr1.length;i++)
			xor^=arr1[i];
		for(int i=0;i<arr2.length;i++)
			xor^=arr2[i];
		//find one of the set bits- the right most bit
		int n=xor;
		int count=0;
		while((n&1)!=1){
			count++;
			n>>=1;
		}
		int set=1<<count;
		int setA=0, setB=0;
		for(int i=0;i<arr1.length;i++){
			if((arr1[i]&set)==set){
				if(setA==0)
					setA=arr1[i];
				else
					setA^=arr1[i];
			}else{
				if(setB==0)
					setB=arr1[i];
				else
					setB^=arr1[i];
			}			
		}
		
		for(int i=0;i<arr2.length;i++){
			if((arr2[i]&set)==set){
					setA^=arr2[i];
			}else{
					setB^=arr2[i];
			}			
		}

	System.out.println(setA + " "+ setB);		
		
	}
	
	/*Write code to generate all possible case combinations of a
	 *  given lower-cased string. (e.g. "0ab" -> ["0ab", "0aB", "0Ab", "0AB"])
	 * */
	public static void allCaseCombinations(String[] str, String pref,int index){
		if(index==str.length){
			System.out.println(pref);
		return;
		}
		String pref1 = pref + str[index].toLowerCase();
		String pref2 = pref + str[index].toUpperCase();
		allCaseCombinations(str, pref1, index+1);
		allCaseCombinations(str, pref2, index+1);		
	}
	
	public static boolean checkIfPalindromic(String[] str){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<str.length;i++){
			if(map.containsKey(str[i])){
				int count = map.get(str[i]);
				count++;
				map.put(str[i],count);
			}
			else
				map.put(str[i], 1);
		}
		
		boolean evenFlag=true;
		boolean oddFlag=false;
		
		for(String s : map.keySet()){
			if(!((map.get(s)%2)==0)){
				if(oddFlag==false){
					oddFlag=true;
				}
				else{
					return false;
				}
			}
		}
		System.out.println("true");
		return true;
	}
	
	/*Input:  arr[] = {1, 2, 3, -4, -1, 4}
    Output: arr[] = {-4, 1, -1, 2, 3, 4}    
    Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
    output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
    get the output in O(n*n) and O(1) space
	 */
	public static void arrange(int[] arr){
		int a = arr.length;
		Math.abs(a);
		String s = "asdf";
		s.toCharArray();
		int negIndex=0, posIndex=0,i=0;
		while(arr[negIndex]>0 && negIndex<arr.length)
			negIndex++;
		while(arr[posIndex]<0 && posIndex<arr.length)
			posIndex++;
		
		
		while(negIndex<arr.length && posIndex<arr.length){
			if(negIndex>posIndex){
				int index=negIndex;
				while(index>posIndex){
					int temp=arr[index];
					arr[index]=arr[index-1];
					arr[index-1]=temp;
					index--;
				}
				
			}
			else{
				if(posIndex==negIndex+1){
					
				}
				else{
					int index=posIndex;
					while(index>negIndex){
						int temp=arr[index];
						arr[index]=arr[index-1];
						arr[index-1]=temp;
						index--;
					}
				}
				
			}
			while(negIndex<arr.length && arr[negIndex]>0)
				negIndex++;
			while( posIndex<arr.length && arr[posIndex]<0)
				posIndex++;
		}

		for(i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
	
	/* In an unsorted array of numbers that occurs an odd number of times except one 
	 * that occurs an even number of times, find the number that occurs an even number of 
	 * times
	 * */
	public static void findNumberOccuringEvenNumberOfTimes(int[] arr){
		int xor=0;
		System.out.println(xor^2);			
	}
	
    //remove all vowels from a string
	public static void removeVowelsFromString(String string){
		String str = new String();
		for(int i=0;i<string.length();i++){
			switch(string.charAt(i)){
			case 'A':continue;
			case 'E':continue;
			 default:break;	         
			}
			str+=string.charAt(i);
		}
		
		System.out.println(str);		
	}
	
	// check if 2 integers differ by a bit
	public static boolean checkIf2IntegersDifferByABit(int a, int b){
		int xor = a ^ b;
		if( (xor&(xor-1))==0 && a!=b){
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		System.out.print(Math.sqrt(17));
		return false;			
	}
	
	public static void MLDataPreprocessing() throws IOException{
		File trainFile = new File("C:\\D Drive\\KNOWLEDGE IS POWER\\ML\\HW1\\car_train.data");
		File testFile = new File("C:\\D Drive\\KNOWLEDGE IS POWER\\ML\\HW1\\car_test.data");
		File validFile = new File("C:\\D Drive\\KNOWLEDGE IS POWER\\ML\\HW1\\car_valid.data");	
		
		
		int train_data[][] = new int[950][21];
		int test_data[][] = new int[389][22];
		int valid_data[][] = new int[389][22];
		
		BufferedReader br = new BufferedReader(new FileReader(trainFile));
		String line = new String();
		int lineNo=0;
		while( (line=br.readLine())!=null){
			String[] tokens = line.split(",");
			
			if(tokens[0].equalsIgnoreCase("vhigh"))
				train_data[lineNo][0]=1;						
			else if(tokens[0].equalsIgnoreCase("high"))
					train_data[lineNo][1]=1;
			else if(tokens[0].equalsIgnoreCase("med"))
					train_data[lineNo][2]=1;
			else if(tokens[0].equalsIgnoreCase("low"))
					train_data[lineNo][3]=1;
			
			if(tokens[1].equalsIgnoreCase("vhigh"))
				train_data[lineNo][4]=1;						
			else if(tokens[1].equalsIgnoreCase("high"))
					train_data[lineNo][5]=1;
			else if(tokens[1].equalsIgnoreCase("med"))
					train_data[lineNo][6]=1;
			else if(tokens[1].equalsIgnoreCase("low"))
					train_data[lineNo][7]=1;
			
			if(tokens[2].equalsIgnoreCase("2"))
				train_data[lineNo][8]=1;						
			else if(tokens[2].equalsIgnoreCase("3"))
					train_data[lineNo][9]=1;
			else if(tokens[2].equalsIgnoreCase("4"))
					train_data[lineNo][10]=1;
			else if(tokens[2].equalsIgnoreCase("5more"))
					train_data[lineNo][11]=1;
			
			if(tokens[3].equalsIgnoreCase("2"))
				train_data[lineNo][12]=1;						
			else if(tokens[3].equalsIgnoreCase("4"))
					train_data[lineNo][13]=1;
			else if(tokens[3].equalsIgnoreCase("more"))
					train_data[lineNo][14]=1;
			
			if(tokens[4].equalsIgnoreCase("small"))
				train_data[lineNo][15]=1;						
			else if(tokens[4].equalsIgnoreCase("med"))
					train_data[lineNo][16]=1;
			else if(tokens[4].equalsIgnoreCase("big"))
					train_data[lineNo][17]=1;
			
			
			if(tokens[5].equalsIgnoreCase("low"))
				train_data[lineNo][18]=1;						
			else if(tokens[5].equalsIgnoreCase("med"))
					train_data[lineNo][19]=1;
			else if(tokens[5].equalsIgnoreCase("high"))
					train_data[lineNo][20]=1;
			
			
			/*if(tokens[6].equalsIgnoreCase("unacc"))
				train_data[lineNo][21]=1;						
			else if(tokens[6].equalsIgnoreCase("acc"))
					train_data[lineNo][21]=2;
			else if(tokens[6].equalsIgnoreCase("good"))
					train_data[lineNo][21]=3;
			else if(tokens[6].equalsIgnoreCase("vgood"))
				train_data[lineNo][21]=4;		*/	
			lineNo++;
		}
		
		br.close();
		
		System.out.print("[");
		for(int i=0;i<train_data.length;i++){
			for(int j=0;j<train_data[0].length;j++){
			    if(j!=train_data[0].length-1)
				 System.out.print(train_data[i][j] + ",");
			    else
			    	System.out.print(train_data[i][j] + ";");
			}	
			if(i!=train_data.length-1)
				System.out.println();
		}
		System.out.print("]");

	}
	
	
	public static void MLDataPreprocessing2() throws IOException{
		File testFile = new File("C:\\D Drive\\KNOWLEDGE IS POWER\\ML\\HW1\\car_test.data");
		File validFile = new File("C:\\D Drive\\KNOWLEDGE IS POWER\\ML\\HW1\\car_valid.data");	

		int test_data[][] = new int[389][21];
		int valid_data[][] = new int[389][21];
		
		BufferedReader br = new BufferedReader(new FileReader(validFile));
		String line = new String();
		int lineNo=0;
		while( (line=br.readLine())!=null){
			String[] tokens = line.split(",");
			
			if(tokens[0].equalsIgnoreCase("vhigh"))
				test_data[lineNo][0]=1;						
			else if(tokens[0].equalsIgnoreCase("high"))
				test_data[lineNo][1]=1;
			else if(tokens[0].equalsIgnoreCase("med"))
				test_data[lineNo][2]=1;
			else if(tokens[0].equalsIgnoreCase("low"))
				test_data[lineNo][3]=1;
			
			if(tokens[1].equalsIgnoreCase("vhigh"))
				test_data[lineNo][4]=1;						
			else if(tokens[1].equalsIgnoreCase("high"))
				test_data[lineNo][5]=1;
			else if(tokens[1].equalsIgnoreCase("med"))
				test_data[lineNo][6]=1;
			else if(tokens[1].equalsIgnoreCase("low"))
				test_data[lineNo][7]=1;
			
			if(tokens[2].equalsIgnoreCase("2"))
				test_data[lineNo][8]=1;						
			else if(tokens[2].equalsIgnoreCase("3"))
				test_data[lineNo][9]=1;
			else if(tokens[2].equalsIgnoreCase("4"))
				test_data[lineNo][10]=1;
			else if(tokens[2].equalsIgnoreCase("5more"))
				test_data[lineNo][11]=1;
			
			if(tokens[3].equalsIgnoreCase("2"))
				test_data[lineNo][12]=1;						
			else if(tokens[3].equalsIgnoreCase("4"))
				test_data[lineNo][13]=1;
			else if(tokens[3].equalsIgnoreCase("more"))
				test_data[lineNo][14]=1;
			
			if(tokens[4].equalsIgnoreCase("small"))
				test_data[lineNo][15]=1;						
			else if(tokens[4].equalsIgnoreCase("med"))
				test_data[lineNo][16]=1;
			else if(tokens[4].equalsIgnoreCase("big"))
				test_data[lineNo][17]=1;
			
			
			if(tokens[5].equalsIgnoreCase("low"))
				test_data[lineNo][18]=1;						
			else if(tokens[5].equalsIgnoreCase("med"))
				test_data[lineNo][19]=1;
			else if(tokens[5].equalsIgnoreCase("high"))
				test_data[lineNo][20]=1;
			
			
			/*if(tokens[6].equalsIgnoreCase("unacc"))
				test_data[lineNo][21]=1;						
			else if(tokens[6].equalsIgnoreCase("acc"))
				test_data[lineNo][21]=2;
			else if(tokens[6].equalsIgnoreCase("good"))
				test_data[lineNo][21]=3;
			else if(tokens[6].equalsIgnoreCase("vgood"))
				test_data[lineNo][21]=4;*/			
			lineNo++;
		}
		
		br.close();
		
		System.out.print("[");
		for(int i=0;i<test_data.length;i++){
			for(int j=0;j<test_data[0].length;j++){
			    if(j!=test_data[0].length-1)
				 System.out.print(test_data[i][j] + ",");
			    else
			    	System.out.print(test_data[i][j] + ";");
			}	
			if(i!=test_data.length-1)
				System.out.println();
		}
		System.out.print("]");

	}


	public static String removeVowels(String str){
		HashSet<Character> set = new HashSet<Character>();
		set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
		String ret = new String();
		for(int i=0;i<str.length();i++){
			if(set.contains(str.charAt(i)))
				continue;
			ret +=str.charAt(i);
		}
		
		System.out.println(ret);
		return ret;		
	}
	
	public static boolean differByOne(int a, int b){
		int xor = a ^ b;
		if( (xor&(xor-1)) == 0)
			return true;
		return false;
	}
	
	public static boolean checkIfRotation(String a, String b){
		String str = a + a;
		if(b.length()!=a.length())
			return false;
		
		for(int i=0;i<str.length()-b.length();i++){
			int k=i, j=0;
			for(j=0;j<b.length();j++){
				if((b.charAt(j)!=str.charAt(k)))
					break;
				k++;				
			}
			if(j==b.length())
				return true;
		}
		return false;
	}
	
	/**
	 * HashSet<Integer> set = new HashSet<Integer> ();
		aRecursionToProveThatStateDoesNotChange(10, set) and the set will have all the 10 integers
		The set is created on the heap.
	 * */
	public static void aRecursionToProveThatStateDoesNotChange(int i, final HashSet<Integer> set) {
		if (i == 0)
			return;
		set.add(new Integer(i));
		aRecursionToProveThatStateDoesNotChange(--i, set);
	}
	
}
