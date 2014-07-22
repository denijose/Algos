package BitWise;



public class Algos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = (int)convertToIntegerFormat("10100");
		//int M = (int)convertToIntegerFormat("101");
		//setBitsBetweenJandIinN(N,M,2,0);
		System.out.println(checkPowerOf2(1));
		
	}

	/*You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j). 
	 * Input: N = 10000000000, M = 10101, i = 2, j = 6
     Output: N = 10001010100*/
	
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
	
	/*Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation. 
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
	
	/* Given an integer, print the next smallest and next largest number that 
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
	
	/*Write a function to determine the number of bits required to convert integer A to integer B. */
	public static void bitSwapRequired(int n, int m){
		int xor = n^m;
		int count=0;
		while(xor>0){
			xor=xor&(xor-1);
			count++;	
		}
		System.out.println(count);
	}
	
	/*check if a number is a power of 2 */
	public static boolean checkPowerOf2(int n){
		return ((n&n-1)==0);
	}
	
}
