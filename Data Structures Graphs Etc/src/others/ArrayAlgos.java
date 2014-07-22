package others;

public class ArrayAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(beautifulRecIsPalin(121,121));

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
}
