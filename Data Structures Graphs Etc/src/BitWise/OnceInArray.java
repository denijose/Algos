package BitWise;

public class OnceInArray {

	/**
	 *Find the element that appears once in an array of elements where each element repeat themselves once - the xor method
	 Find the Number Occurring Odd Number of Times
	 */
	public static void main(String[] args) {

		int a[] = {1,1,2,2,4,4,-9,-9,8,8,8};
		find(a);

	}
	
	public static void find(int[] a){
		int x=a[0];
		for(int i=1;i<a.length;i++){
			x^=a[i];
		}
		
		System.out.println(x);
	}

}
