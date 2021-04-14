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
			return arr[low];
		}
		int mid = low + (high - low)/2;
		st[si] = Math.min(build(arr, low, mid, 2*si + 1),
		build(arr, mid+1, high, 2*si + 2));
		return st[si];
	}
	int getMin(int qs, int qe, int low, int high, int si){
		if(high<qs || low>qe){
			return Integer.MAX_VALUE;
		}
		if(qs<=low && qe>=high){
			return st[si];
		}
		int mid = (low + (high - low)/2);
		return Math.min(getMin(qs, qe, low, mid, 2*si+1), 
		getMin(qs, qe, mid+1, high, 2*si+2));
	}
	void update(int low, int high, int idx, int si, int val){
		if(idx<low || idx>high)
			return;
		if(low==high){
			st[si] = val;
			return;
		}
		int mid = low + (high - low)/2;
		update(low, mid, idx, 2*si+1, val);
		update(mid+1, high, idx, 2*si+2, val);
		st[si] = Math.min(st[2*si + 1], st[2*si + 2]);
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, -2, 7, 9, 11};
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr);
		System.out.println(tree.getMin(1, 5, 0, n-1, 0));
		tree.update(0, n-1, 3, 0, -4); 
  
        // Find sum after the value is updated 
        System.out.println(tree.getMin(1, 5, 0, n-1, 0)); 
	}
}