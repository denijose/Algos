package BitWise;



public class Algos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertToIntegerFormat("10");

	}

	/*You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j). */
	public static void setBitsBetweenJandIinN(int N, int M,int j, int i){
		int right = N | 1<<i;
		int left = N & 1<<j;
		M = M << i;
		N = left | M;
		N = N | right;		
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
		for(int i=tokens.length-2; i>=0 ;i--)
			n += (Double.parseDouble(tokens[i])) * (Math.pow((double)2,(double)i));
		System.out.println(n);
		return n;
			
		
	}
	
}
