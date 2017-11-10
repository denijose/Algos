package Recursion;

public class CombinationsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String array[] = new String[]{"a", "b", "c"} ;
		//combWithOrder(array,"",-1,3);		
		// permutations(array,  "", 3, 0);
		//for(int i =1;i<=array.length;i++)
		//	combWithOrder(array,"",0,2);
		//perm(array,0);
        subSeq2(array,"",1,array.length);
	}
	
	public static void combWithOrder(String[] array,String prefix, int index, int n){
		if(prefix.length()==n){
			//System.out.println(prefix);
			perm(prefix.split(""),0);
			return;
		}
		String pref = "";
		for(int i=index;i<array.length;i++){
			pref = prefix + array[i];
			combWithOrder(array, pref, i+1, n);
		}		
	}
	
	public static void perm(String[] arr, int index){
		if(index == arr.length-1){
			for(int i=0;i<arr.length;i++)
			 System.out.print(arr[i]);
			System.out.println();
		 return;
		}
		
		for(int i=index;i<arr.length;i++){			
				arr = swap(arr,index,i);
				perm(arr,index+1);
			    arr = swap(arr,i,index);
			}
	}
	
	public static String[] swap(String[] arr, int i, int j){
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;		
	}
	
	
	// get all subsequences of an array/string
	public static void subSeq(String[] arr, String pref, int i,int count){
		if(count==0){
			System.out.println(pref);
			return;
		}
		
		String prefix1 = pref + arr[i];
		String prefix2 = pref;
		subSeq(arr, prefix1, i+1,count-1);
		subSeq(arr,prefix2,i+1,count-1);
			
	}

	//get all subsequences of a particular legnth
	public static void subSeq2(String[] arr, String pref, int index, int count){
		if(count==0){
			System.out.println(pref);
			return;
		}
		for(int i=index;i<arr.length;i++){
			String prefix1 = pref + arr[i];
			subSeq2(arr, prefix1, i+1,count-1);
		}
	}
}
