package BitWise;



public class Algos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int N = (int)convertToIntegerFormat("10100");
		//int M = (int)convertToIntegerFormat("101");
		//setBitsBetweenJandIinN(N,M,2,0);
		//System.out.println(checkPowerOf2(1));
		int[] a = new int[]{5,3,4,2,5,6,6,1};
		findTwoRepeatingEleInArray(a);
		
	}

	/* Prob 5.1
	 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
	 * Write a method to set all bits between i and j in N equal to M 
	 * (e.g., M becomes a substring of N located at i and starting at j). 
	 * Input: N = 10000000000, M = 10101, i = 2, j = 6
       Output: N = 10001010100
     */
	
	public static void setBitsBetweenJandIinN(int N, int M, int j, int i){
		int right = N | 1<<i;
		int left = N & 1<<j;
		M = M << i;
		N = left | M;
		N = N | right;
		convertToBinaryFormat(N);
	}
	
	public static String convertToBinaryFormat(int n){
		String binary = "";
		while(n > 0){
			if(n%2==0)
				binary = "0" + binary;
			else
				binary = "1" + binary;
			n >>= 1;
		}
		System.out.println(binary);
		return binary;
	}
	
	public static double convertToIntegerFormat(String binary){
		String tokens[] = binary.split("");
		double n = 0; 
		int power = 0;
		for(int i=tokens.length-1; i>0 ;i--)
			n += (Double.parseDouble(tokens[i])) * (Math.pow((double)2,(double)power++));
		System.out.println(n);
		return n;		
		
	}
	
	/*Prob 5.2
	 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation. 
	 * If the number can not be represented accurately in binary, print “ERROR” */
	public static void convertToBinary2(String n){
		String[] tokens = n.split("\\.");
		int integerPart = Integer.parseInt(tokens[0]);
		double decPart = Double.parseDouble("." + tokens[1]);
		
		String integerString = "";
		while(integerPart>0){
			int r = integerPart%2;
			integerString = r + integerString;
			integerPart >>= 1;
		}
		
		String decString = null;
		while(decPart>0){
			double r = 2*decPart;
			System.out.println(r);
			if(r>=1){
				decString = "1" + decString;
				decPart = r-1;
			}	
			else{
				decString = "0" + decString;
				decPart = r;
		    }
		}
		
		System.out.println(integerString+"."+decString);
	}
	
	/* Prob 5.3
	 * Given an integer, print the next smallest and next largest number that 
	 * have the same number of 1 bits in their binary representation.
	 */
	public static void sameNoOfOnes(int n){
		convertToBinaryFormat(n);
		int index=0;
		while(!isSet(n,index++));  //find the first 1 moving from right to left
		while(isSet(n,index++)); //find the first 0 after finding the first 1
		n=turnOn(n,--index); //turn on the 0 thats found
		convertToBinaryFormat(n);
		index--;
		while(!isSet(n,index--)); //find the 1 to the right side of the set 0
		n=turnOff(n,++index);
		convertToBinaryFormat(n);
	}
	
	public static boolean isSet(int n, int index){
		return( (n&(1<<index)) > 0) ;
	}
	
	public static int turnOn(int n, int index){
		return n|1<<index;
	}
	
	public static int turnOff(int n, int index){
		return n & ~(1<<index);
	}
	
	/* Prob 5.5
	 * Write a function to determine the number of bits required to convert integer A to integer B. */
	public static void bitSwapRequired(int n, int m){
		int xor = n^m;
		int count=0;
		while(xor>0){
			xor=xor&(xor-1);
			count++;	
		}
		System.out.println(count);
	}
	
	/* Prob 5.4
	 * check if a number is a power of 2 */
	public static boolean checkPowerOf2(int n){
		return ((n&n-1)==0);
	}
	
	
	// Find the two non-repeating elements in an array of repeating elements
	// or finding two numbers that occur odd number of times with org.denisjos.algos occuring even number
	public static void findTwoNonRepeatingEleInArray(int[] a){
		int xor=a[0];
		for(int i=1;i<a.length;i++){
			xor^=a[i];
		}
		//find any one of the set bits - i will find the right most set bit
		int set=xor&~(xor-1);
		//create two sets seperating whether the set bit is also set in the number and xor the numbers in each set
		int xorOfSet1=0, xorOfSet2=0;
		for(int i=0;i<a.length;i++){
			if((set & a[i])==0){
				if(xorOfSet1==0)
					xorOfSet1=a[i];
				else
					xorOfSet1^=a[i];
			}			
			else{
				if(xorOfSet2==0)
					xorOfSet2=a[i];
				else
					xorOfSet2^=a[i];
			}
		}
		
		System.out.println(xorOfSet1 + " " + xorOfSet2);
	}
	
	
	//Find the two repeating elements in a given array containing numbers from 1 to n
	/*You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
	 * And all elements occur once except two numbers which occur twice. 
	 * Find the two repeating numbers
	 * */
	public static void findTwoRepeatingEleInArray(int[] a){
		// getting x xor y by xoring all the numbers from 1 to n and each a[i]
		int xor=a[0];
		for(int i=1;i<a.length;i++){
			xor^=a[i];
		}
		for(int i=1;i<=a.length-2;i++)
			xor^=i;
		// now xor=x^y;
		// to get x and y out of xor , we know that the bits set in xor is set in only of x or y and not both
		// we find one of the bits set in xor - the right most bit
		int set = xor & ~(xor-1);
		
		// we seperate the numbers that have the bit set and not set and xor them together with their duplicates
		int xorOfSet1=0, xorOfSet2=0;
		
					
		for(int i=0;i<a.length;i++){
			if((set&a[i])==0){
				if(xorOfSet1==0)
					xorOfSet1=a[i];
				else
					xorOfSet1^=a[i];
			}
			else{
				if(xorOfSet2==0)
					xorOfSet2=a[i];
				else
					xorOfSet2^=a[i];				
			}
		}
		
		// find out the numbers from 1 to n who have the bit set
		for(int i=1;i<=a.length-2;i++){
			if((set&i)==0)
				xorOfSet1^=i;			
			else
				xorOfSet2^=i;				
		}
		
		
		System.out.println(xorOfSet1 + " " + xorOfSet2);		
	}
	
	
	
}
