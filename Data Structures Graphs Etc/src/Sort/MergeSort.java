package Sort;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {22,3,-2,35,34,1,2};
		mergeSort(a,0,a.length-1);
		for(int i=0; i<a.length;i++)
			System.out.println(a[i]);
		

	}

	public static void mergeSort(int[] a, int left, int right){
		if(left==right)
			return;		
		int mid = (left+right)/2;
		mergeSort(a,left, mid);
		mergeSort(a,mid+1,right);
		merge(a,left,mid,right);
		for(int i=0; i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void merge(int[] a , int left, int mid, int right){
		int index=left;
		while(index!=mid+1){
			if(a[index]>a[mid+1]){
				int temp1 = a[mid+1];
				a[mid+1] = a[index];
				a[index] = temp1;
			}
			index++;
		}
		while(index!=right){
			if(a[index]>a[index+1]){
				int temp1 = a[index+1];
				a[index+1] = a[index];
				a[index] = temp1;
			}
			index++;
		}
	}
	
}
