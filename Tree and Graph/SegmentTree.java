class SegmentTree{
	int st[];
	SegmentTree(int arr[]){
		int n = arr.length;
		st = new int[4*n];
		build(arr, 0, n-1, 0);
	}
	int build(int arr[], int low, int high, int si){
		if(low == high){
			st[si] = arr[low];
			return arr[high];
		}
		int mid = low + (high - low)/2;
		st[si] = build(arr, low, mid, 2*si + 1) + 
		build(arr, mid+1, high, 2*si + 2);
		return st[si];
	}
	int getSum(int qs, int qe, int low, int high, int si){
		if(high<qs || low>qe){
			return 0;
		}
		if(qs<=low && qe>=high){
			return st[si];
		}
		int mid = (low + (high - low)/2);
		return getSum(qs, qe, low, mid, 2*si+1) +
		getSum(qs, qe, mid+1, high, 2*si+2);
	}
	void update(int low, int high, int idx, int si, int diff){
		if(idx<low || idx>high)
			return;
		st[si] += diff;
		if(high>low){
			int mid = (low + (high-low)/2);
			update(low, mid, idx, 2*si+1, diff);
			update(mid+1, high, idx, 2*si+2, diff);
		}
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr);
		System.out.println(tree.getSum(1, 3, 0, n-1, 0));
		tree.update(0, n-1, 1, 0, 10-arr[1]); 
  
        // Find sum after the value is updated 
        System.out.println(tree.getSum(1, 3, 0, n-1, 0)); 
	}
}