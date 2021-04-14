class ArticulationPoint{
	private int V;
	private LinkedList<Integer> adj[];
	int time =0;
	static final int NIL = -1;

	ArticulationPoint(LinkedList<Integer> adj[]){
		//no. of vertices
		V=adj.length;
		this.adj = adj;

	}
	boolean[] AP(){
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];
		boolean ap[] = new boolean[V];

		Arrays.fill(parent, NIL);
		for(int i=0; i<V; i++){
			if(!visited[i])
				APUtil(i, visited, disc, low, parent, ap);
		}
		return ap;

	}
	void APUtil(int u, boolean visited[], int disc[], int low[], int parent[], boolean ap[]){
		// count of children in DFS tree
		int children = 0;

		visited[u] = true;
		disc[u] = low[u] = ++time;

		for(int v: adj[u]){
			if(!visited[v]){
				children++;
				parent[v] = u;
				APUtil(v, visited, disc, low, parent, ap);

				low[u] = Math.min(low[v], low[u]);

				if(parent[u]==NIL && children>1)
					ap[u] = true;

				if(parent[u]!=NIL && low[v]>=disc[u])
					ap[u] = true;
			}else{
				if(v!=parent[u]){
					low[u] = Math.min(low[u], disc[v]);
				}
			}
		}

	}
}

