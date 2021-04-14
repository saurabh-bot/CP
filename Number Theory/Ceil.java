	//Code for finding the index of the ceil element in java
    //else return -1
	static int ceil(int arr[], int x){
		int n = arr.length;
		int low = 0, high = n-1;
		int mid=0;
		while(low<high){
			mid = (low + high)/2;
			if(arr[mid]<=x)
				low = mid+1;
			else
				high = mid;
		}
		if(arr[high]<=x)
			return -1;
		else
			return high;
	}