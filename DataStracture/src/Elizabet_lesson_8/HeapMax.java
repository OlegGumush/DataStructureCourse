package Elizabet_lesson_8;


/** The root of the tree is A[1], i is the of a node
    the Max-Heap Property : for every node i other than the root:
    A[parent[i]]>=A[i], that is the value of the node
	is at most the value of its parent.
    Thus, the largest element in a max-heap is stored at the root.
**/
/** Constructor */
public class HeapMax {
	int _negativeInfinity = -99999;
	private int _a[];
	private int _size;
	public HeapMax(int arr[]){
		_size = arr.length;
		_a = new int[_size];
		for (int i=0; i<_size; i++){
			_a[i]=arr[i];
		}
		buildMaxHeap();
	}
	/** parent returns the parent of vertex  i*/
	private  int parent(int i){return (i-1)/2;}
	/** leftChild returns the left child of vertex  i*/
	private  int leftChild(int p){return 2*p+1;}
	/** rightChild returns the right child of vertex  i*/
	private  int rightChild(int p){return 2*p+2;}
	/** returns the heap maximum */
	public int heapMaximum(){return _a[0];}
	/** returns true if the heap is empty, otherwise false */
	public boolean isEmpty(){return _size == 0;}	
	/** 
	 * The maxHeapfy maintains the Max-Heap Property
	 * complexity is O(log2(n))
	 * @param _a - array of numbers
	 * @param v - vertex 
	 * @param heapSize - size of the heap
	 * The function of maxHeapfy is to let the value of a[v] "float-down"
	 * in the Max-Heap so that subtree rooted at index v becomes a Max-Heap
	 */
	private void maxHeapify(int v, int heapSize){
		int largest;
		int left = leftChild(v);
		int right = rightChild(v);
		if (left<heapSize && _a[left]>_a[v]){
			largest = left;
		}
		else{
			largest = v;
		}
		if (right<heapSize && _a[right]>_a[largest]){
			largest = right;
		}
		if (largest!=v){
			exchange(v, largest);
			maxHeapify(largest, heapSize);
		}		
	}
	/** 
	 * buildMaxHeap produces a Max-Heap from an unordered input array.
	 * buildMaxHeap runs in linear time O(n)
	 * complexity O(n*log2(n))
	 */
	public void buildMaxHeap(){
		for (int i=_size/2; i>=0; i--){
			maxHeapify(i, _size);
		}
	}
	/** heapSort sorts an array in place
	 * complexity is O(n*log(n))
	**/
	
	public void heapSort(){
			int heapSize = _size;
			for (int i=heapSize-1; i>=1; i--){
				exchange(0, i);
				heapSize = heapSize - 1;
				maxHeapify(0, heapSize);
			}
	}
	/**
	 *  heapExtractMax removes and returns the largest element of heap
	 * O(log(n))
	 **/
	public int heapExtractMax(){
		int max = _negativeInfinity; // infinity
		if (!isEmpty()){
			max = _a[0];
			_a[0]=_a[_size-1];
			_size = _size-1;
			maxHeapify(0, _size);
		}
		return max;
	}
	/**
	 * heapIncreaseKey(v, key) increases the value of element v-s key 
	 * to the new value key, which is assumed to be at least as large
	 * as v's current key value
	 * complexity O(log2(n))
	 */
	private void heapIncreaseKey(int i, int key){
		if (key >=_a[i]){
			_a[i] = key;
			while (i>0 && _a[parent(i)]<_a[i]){
				exchange(i, parent(i));
				i = parent(i);
			}
		}
	}
	/**
	 * heapInsert(key) inserts the element key into a heap
	 * complexity O(log2(n))
	 */
	public void heapInsert(int key){
		resize(1);
		_a[_size-1] = _negativeInfinity;
		heapIncreaseKey(_size-1, key);
	}
	private void resize(int increment){
		int temp[] = new int[_size+increment];
		for (int i=0; i<_size; i++){
			temp[i]=_a[i];
		}
		_a = temp;
		_size = _size+increment;
	}
	/**
	 * exchange two elements of an array
	 * @param i - index (0 <= i <= a.length)
	 * @param j - index (0 <= j <= a.length)
	 * complexity O(1)
	 */
	private void exchange(int i, int j){
		int t = _a[i];
		_a[i] = _a[j];
		_a[j] = t;
	}
	/** print a heap array 
	 * complexity O(n)
	 * */
	public void print(){
		for (int i=0; i<_size; i++){
			System.out.print(_a[i]+", ");
		}
		System.out.println();
	}
	public static boolean isMaxHeap(int[] arr){
		boolean ans = true;
		for (int i=0; ans && i<arr.length/2; i++){
			int left = i*2 + 1;
			int right = i*2 + 2;
			if (left<arr.length && arr[i]<arr[left]) ans = false;
			if (ans && right<arr.length && arr[i]<arr[right]) ans = false;
		}
		return ans;
	}
	public static void main(String[] args) {
//		int arr[] = {5,13,2,25,7,17,2,8,4};
//		int arr[] = {1,2,4,8,16,3,9,7,10,14};
		int arr2[] = {1,2,4,8,16};
		int arr[] = {16,8,4,2,1};
		int arr1[] = {16,14,10,8,7,9,3,2,4,1};
		HeapMax hp = new HeapMax(arr1);
		hp.buildMaxHeap();
		hp.print();
	/////// 
		System.out.println("is max heap? " + isMaxHeap(arr));
		System.out.println("is max heap? " + isMaxHeap(arr2));
		System.out.println("is max heap? " + isMaxHeap(hp._a));
		System.out.println("is max heap? " + isMaxHeap(arr1));
	//insert
		hp.heapInsert(-1);
		hp.print();
		hp.heapSort();
		hp.print();
		hp.heapExtractMax();
		hp.print();
		hp.heapExtractMax();
		hp.print();
		hp.heapSort();
		hp.print();
	}
}
