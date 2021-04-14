/*-----------------------------------------------------
Dijkstra implementation through Priority Queee
It is not highly optimized as we are pushing all
edges in priority queue, 
this can be improved using map and get the node 
location in array for which we want decrease key 
operation 
-------------------------------------------------------
*/
import java.util.*;
class Dijkstra{
	int dist[];
	ArrayList<Node> adj[];
	int V;
	PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p1, p2) -> p1.weight - p2.weight);

	Dijkstra(ArrayList<Node> adj[]){
		this.adj = adj;
		V = adj.length;
		dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
	}
	int[] shortestPath(int src){
		pq.add(new Pair(src, 0));
		dist[src]=0;
		for(int i=0; i<V; i++)
			if(i!=src)
				pq.add(new Pair(i, Integer.MAX_VALUE));
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int u = p.vertex;
			for(Node node: adj[u]){
				int v = node.dest;
				int w = node.weight;
				if(dist[v]>dist[u] + w){
					dist[v] = dist[u] + w;
					pq.add(new Pair(v, dist[v]));
				}
			}
		}
		return dist;
	}
	public static void main(String[] args) {
		int n = 9;
		ArrayList<Node> adj[] = new ArrayList[n];
		for(int i=0; i<n; i++){
			adj[i] = new ArrayList<Node>();
		}
		addEdge(adj, 0, 1, 4);
		addEdge(adj, 0, 2, 8);
		addEdge(adj, 1, 2, 11);
		addEdge(adj, 1, 3, 8);
		addEdge(adj, 3, 4, 2);
		addEdge(adj, 3, 7, 4);
		addEdge(adj, 2, 4, 7);
		addEdge(adj, 2, 5, 1);
		addEdge(adj, 4, 5, 6);
		addEdge(adj, 5, 7, 2);
		addEdge(adj, 6, 7, 14);
		addEdge(adj, 6, 8, 9);
		addEdge(adj, 7, 8, 10);
		addEdge(adj, 3, 6, 7);

		Dijkstra dj = new Dijkstra(adj);
		int res[] = dj.shortestPath(1);
		for(int i=0; i<n; i++){
			System.out.println((char)(i+65) + " " + res[i]);
		}
	}
	static void addEdge(ArrayList<Node> adj[], int src, int dest, int wt){
		adj[src].add(new Node(dest, wt));
		adj[dest].add(new Node(src, wt));
	}
}
class Pair{
	int vertex, weight;
	Pair(int vertex, int weight){
		this.vertex = vertex;
		this.weight = weight;
	}
}
class Node{
	int dest, weight;
	Node(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
}