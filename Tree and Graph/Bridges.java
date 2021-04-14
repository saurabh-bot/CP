class Bridges{
	private int V;
	private LinkedList<Integer> adj[];
	int time =0;
	static final int NIL = -1;

	Bridges(LinkedList<Integer> adj[]){
		//no. of vertices
		V=adj.length;
		this.adj = adj;

	}
	void bridges(){
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];

		Arrays.fill(parent, NIL);
		for(int i=0; i<V; i++){
			if(!visited[i])
				bridgeUtil(i, visited, disc, low, parent);
		}
	}
	void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]){

		visited[u] = true;
		disc[u] = low[u] = ++time;

		for(int v: adj[u]){
			if(!visited[v]){
				parent[v] = u;
				bridgeUtil(v, visited, disc, low, parent);

				low[u] = Math.min(low[v], low[u]);

				if(low[v]>disc[u])
					System.out.println(u + " " + v);
			}else{
				if(v!=parent[u]){
					low[u] = Math.min(low[u], disc[v]);
				}
			}
		}

	}
}

