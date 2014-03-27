package Recursion;

public class CombinationsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String array[] = new String[]{"a", "b", "c", "d"} ;
		permutations(array,"",2,0);		

	}

	public static void permutations(String[] array, String prefix, int r, int index){
		if(r==0){
			System.out.println(prefix);
			return;
		}
		
		String pref = null;
		for(int i=index; i<array.length;i++){
			pref = prefix + array[i];
			permutations(array, pref, r-1, i+1);
			
		}
	}
}
