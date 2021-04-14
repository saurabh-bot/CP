public class Heap{
	static void heapify(int arr[], int n, int i){
		int smallest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;

		if(l<n && arr[l]<arr[smallest])
			smallest = l;
		if(r<n && arr[r]<arr[smallest])
			smallest = r;

		if(smallest!=i){
			arr[smallest]^=arr[i];
			arr[i]^=arr[smallest];
			arr[smallest]^=arr[i];

			heapify(arr, n, smallest);
		}
	}
	static void buildHeap(int arr[], int n){
		int startIdx = (n-1)/2;
		for(int i=startIdx; i>=0; i--){
			heapify(arr, n, i);
		}
	}
	static void printHeap(int arr[]){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	static void insert(int arr[], int n, int val){
		arr[n-1] = val;
		for(int i=n-1; i!=0 && arr[(i-1)/2]>arr[i]; ){
			int parent = (i-1)/2;
			if(arr[parent]<arr[i])
				break;
			arr[parent]^=arr[i];
			arr[i]^=arr[parent];
			arr[parent]^=arr[i];
			i = parent;
		}
	}
	public static void main(String[] args) {
		int arr[] = new int[20];
        arr[0]=17;
        arr[1]=3;
        arr[2]=5;
        arr[3]=15;
        arr[4]=4;
        arr[5]=6;
        arr[6]=1;
        arr[7]=8;
        arr[8]=10;
        arr[9]=9;
        arr[10]=13;
		buildHeap(arr, 11);
		printHeap(arr);
		insert(arr, 12, 2);
		printHeap(arr);
	}
}