package Sort;

public class MergeSort {

	/**
	 * @param args
	 */
	static int temp[] = null;
	
	public static void main(String[] args) {
		int A[] = {2, 1, 1, 2, 3, 1};
		temp = new int[A.length];
		mergeSort2(A,0,A.length-1);
        int count=1;
        int curr=temp[0];        
        for(int i=1;i<temp.length;i++){
            System.out.print(temp[i] + " ");
            if(curr!=temp[i])
               count++;
            curr = temp[i];            
        }
        System.out.print(count);
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
	
    public static void mergeSort2(int[] A, int low, int high){
        if(low>=high)
            return;
        int mid = (high + low)/2;
        
        mergeSort2(A, low, mid);
        mergeSort2(A, mid+1, high);
        merge2(A, low, mid, high);
}

public static void merge2(int[] A, int low, int mid, int high){
    int i=low, j=mid+1;
    int k=low;
    while(i<=mid || j<=high){
        if(i<=mid && j<=high){
            if(A[i] < A[j]){
                temp[k++] = A[i++];
            }
            else
                temp[k++] = A[j++];
        } else if(i<=mid){
            temp[k++] = A[i++];
        } else if(j<=high){
            temp[k++] = A[j++];
        }  
        
    } 
    
    for (i = low; i <= high; i++) {
        A[i] = temp[i];
      }
}
	
}
