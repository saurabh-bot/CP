import java.util.*;

class Prims{
	int V;
	ArrayList<Node> adj[];
	Prims(int v){
		V = v;
		adj = new ArrayList[v];
		for(int i=0; i<v; i++)
			adj[i] = new ArrayList<Node>();
	}
	void addEdge(int src, int dest, int weight){
		Node node1 = new Node(dest, weight);
		adj[src].add(node1);
		Node node2 = new Node(src, weight);
		adj[dest].add(node2);
	}
	void primsMST(){
		boolean visited[] = new boolean[V];
		int parent[] = new int[V];
		Node2 temp[] = new Node2[V];
		for(int i=0; i<V; i++){
			temp[i] = new Node2(i, Integer.MAX_VALUE);
			parent[i] = -1;
 		}
 		visited[0] = true;
 		temp[0].key = 0;
		TreeSet<Node2> queue = new TreeSet<Node2>((t1, t2) -> t1.key - t2.key);

		for(int i=0; i<V; i++){
			queue.add(temp[i]);
		}
		while (!queue.isEmpty()) {
			Node2 top = queue.pollFirst();
			visited[top.vertex]=true;

			for(Node neighbour : adj[top.vertex]){
				if(!visited[neighbour.dest]){
					if(temp[neighbour.dest].key > neighbour.weight){
						queue.remove(temp[neighbour.dest]);
						temp[neighbour.dest].key = neighbour.weight;
						queue.add(temp[neighbour.dest]);
						parent[neighbour.dest] = top.vertex;
					}
				}
			}
			
		}

		System.out.println(" --------------------------- ");
		for(int i = 1; i<V; i++){
			System.out.println(parent[i] + " " + i);
		}
		for(int i=0; i<V; i++){
			System.out.println(i + " ");
			for(Node x : adj[i]){
				System.out.print(x.dest + "  ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Prims e = new Prims(9);

		e.addEdge(0, 1, 4); 

        e.addEdge(0, 7, 8); 
        e.addEdge(1, 2, 8); 
        e.addEdge(1, 7, 11);

        e.addEdge(2, 3, 7); 
        e.addEdge(2, 8, 2); 
         e.addEdge(2, 5, 4);

        e.addEdge(3, 4, 9); 
        e.addEdge(3, 5, 14); 
        e.addEdge(4, 5, 10); 
        e.addEdge(5, 6, 2); 
        e.addEdge(6, 7, 1); 
        e.addEdge(6, 8, 6); 
        e.addEdge(7, 8, 7); 
        
        e.primsMST();
  
	}

}
class comparator implements Comparator<Node2> { 
  
    @Override
    public int compare(Node2 a, Node2 b) 
    { 
        return a.key - b.key; 
    } 
} 
class Node{
	int dest, weight;
	Node(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
}
class Node2{
	int vertex, key;
	Node2(int vertex, int key){
		this.vertex = vertex;
		this.key = key;
	}
}