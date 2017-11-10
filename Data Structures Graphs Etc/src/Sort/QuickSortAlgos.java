package Sort;

public class QuickSortAlgos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {3,7,8,5,2,1,9,5,4};
		quickSort(arr,0,arr.length-1);
		for(int i:arr)
			System.out.print(i + " ");

	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(low>=high)
			return;
		
		  int pivotIndex = partition(arr,low,high);
		  quickSort(arr,low,pivotIndex-1);
		  quickSort(arr,pivotIndex+1,high);
		
	}
	
	public static int partition(int[] arr, int low, int high){
		int pivotIndex = (high+low)/2;
		int pivotValue = arr[pivotIndex];
		// shift pivotValue to the end
	    arr[pivotIndex] = arr[high];
	    arr[high] = pivotValue;
	    int storeIndex = low;
	    for(int i=low;i<=high-1;i++){
	    	if(arr[i] < pivotValue){
	    		int temp = arr[i];
	    		arr[i] = arr[storeIndex];
	    		arr[storeIndex] = temp;
	    		storeIndex++;
	    	}
	    }
	    //swap arr[storeIndex] and arr[high] ie get the pivotValue back to the correct place
	    arr[high] = arr[storeIndex];
	    arr[storeIndex] = pivotValue;
	    return storeIndex;
	    
	}
	
	

}
