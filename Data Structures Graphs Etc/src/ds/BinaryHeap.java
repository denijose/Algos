package ds;

public class BinaryHeap {

private int[] heap;

    private String type;

    public int size;

    

    public BinaryHeap(int n, String type){

    size=n;

        heap=new int[n];

        this.type=type;

    }

    

    // creating a heap out of an array in O(n) runtime

    public BinaryHeap(int[] array,String type){

    heap=array;

    size=heap.length;

    this.type=type;

        if(type.equalsIgnoreCase("min"))

        createMinHeap();

        if(type.equalsIgnoreCase("max"))

        createMaxHeap();

    }

    

    public void createMinHeap(){
	    for(int i=size/2-1;i>=0;i--){
		    int minChildIndex;
		    int cur=i;
		    while((2*cur+1)<size){
			    if(2*cur+2>=size)
			        	minChildIndex=2*cur+1;
			    else if(heap[2*cur+1] < heap[2*cur+2])
			        	minChildIndex=2*cur+1;
			    else 
			        minChildIndex=2*cur+2;
			    if(heap[cur]>heap[minChildIndex]){
				        heap[cur]=heap[cur]+heap[minChildIndex];
				        heap[minChildIndex]=heap[cur]-heap[minChildIndex];
				        heap[cur]=heap[cur]-heap[minChildIndex];
			    }
			        cur=minChildIndex;
			    }
	    }
    }

    

   public void createMaxHeap(){

    for(int i=size/2-1;i>=0;i--){

    int maxChildIndex;

    int cur=i;

    while((2*cur+1)<size){

    if(2*cur+2>=size)

        maxChildIndex=2*cur+1;

        else if(heap[2*cur+1]>heap[2*cur+2])

        maxChildIndex=2*cur+1;

        else

        maxChildIndex=2*cur+2;

        if(heap[cur]<heap[maxChildIndex]){

        heap[cur]=heap[cur]+heap[maxChildIndex];

        heap[maxChildIndex]=heap[cur]-heap[maxChildIndex];

        heap[cur]=heap[cur]-heap[maxChildIndex];

        }

        cur=maxChildIndex;

    }

   

    }

    }

    

    public int del(){

    if(type.equalsIgnoreCase("min"))

        return delMin();

        if(type.equalsIgnoreCase("max"))

        return delMax();

return 0;

    }

    

    private int delMax(){

        int retValue = heap[0];

        heap[0]=heap[size-1];

        int i=0;

        while(2*i+1<size){

        int maxChildIndex=2*i+1;

        if(2*i+2<size && heap[2*i+2]>heap[maxChildIndex])

        maxChildIndex=2*i+2;

        if(heap[i]<heap[maxChildIndex]){

        int temp=heap[i];

        heap[i]=heap[maxChildIndex];

        heap[maxChildIndex]=temp;

        }

        i=maxChildIndex;

        }

        size=size-1;

        return retValue;

    }

    

    private int delMin(){
        int retValue=heap[0];
        heap[0]=heap[size-1];
        size--;
        int i=0;
        while(2*i+1<size){
        int minChildIndex=2*i+1;
        if(2*i+2<size && heap[2*i+2]<heap[minChildIndex])
        minChildIndex=2*i+2;
        if(heap[i]>heap[minChildIndex]){
        int temp=heap[i];
        heap[i]=heap[minChildIndex];
        heap[minChildIndex]=temp;
        }
        i=minChildIndex;
        }        
        return retValue;
    }

    

    public void insert(int n){

    if(type.equalsIgnoreCase("min"))

    insertMin(n);

        if(type.equalsIgnoreCase("max"))

        insertMax(n);

    }

    

    private void insertMin(int n){

    size++;

        heap[size-1]=n;

        //heapify up

        int i=size-1;        

        while(i>0){

        int parentIndex;

        if(i%2==0)

        parentIndex=i/2-1;

        else

        parentIndex=i/2;

        if(heap[i]<heap[parentIndex]){

        int temp = heap[i];

        heap[i] = heap[parentIndex];

        heap[parentIndex] = temp;

        }

        i=parentIndex;        	

        }

    }

    

    private void insertMax(int n){

    size++;

    heap[size-1]=n;

    int i=size-1;

    while(i>0){

    int parentIndex;

    if(i%2==0)

    parentIndex=i/2-1;

    else

    parentIndex=i/2;

    if(heap[i]>heap[parentIndex]){

    int temp = heap[i];

        heap[i] = heap[parentIndex];

        heap[parentIndex] = temp;

    }

    i=parentIndex;    	

    }        

    }

    

    private int getLeftChild(int i){

        return heap[2*i+1];

    }

    

    private int getRightChild(int i){

        return heap[2*i+2];

    }

    

    private int getParent(int i){

    if(i%2==0)

    return heap[i/2-1];

    else

    return heap[i/2];    	

    }

    

    

    public void BFS(){

    for(int i=0;i<size;i++)

    System.out.println(heap[i] + " ");

    }
    
    
    public static void main(String[] args) {

        int array[] = new int[]{2,3,10,1,8,7};

    BinaryHeap h = new BinaryHeap(array,"max");

    System.out.println(h.del());

    //h.BFS();

    h.insert(20);

    h.BFS();

    }

    

    

}
