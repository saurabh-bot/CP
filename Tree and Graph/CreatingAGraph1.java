import java.util.*;
public class CreatingAGraph1{

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
		adj.get(u).add(v);
	}
	static void printGraph(ArrayList<ArrayList<Integer>> adj){
		for(int i=0; i<adj.size(); i++){
			for(int j=0; j<adj.get(i).size(); j++){
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
		for(int i=0; i<v; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj, 0, 1);
		addEdge(adj, 2, 0  );
		addEdge(adj, 0, 3);
		addEdge(adj, 0, 5);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 2, 4);
		addEdge(adj, 2, 5);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);

		printGraph(adj);
		if(isCycle(adj, 6))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	//Detecting a cycle in a directed graph
	static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V){
		boolean visited[] = new boolean[V];
		boolean recSt[] = new boolean[V];
		for(int i=0; i<V; i++){
			if(!visited[i]){
				if(detectCycle(visited, recSt, adj, i)){
					return true;
				}
			}
		}
		return false;
	}

	static boolean detectCycle(boolean visited[], boolean recSt[], ArrayList<ArrayList<Integer>> adj, int s){
		visited[s] = true;
		recSt[s] = true;
		for(int i:adj.get(s)){
			if(!visited[i]){
				if(detectCycle(visited, recSt, adj, i))
					return true;
			}else{
				if(recSt[i])
					return true;
			}
		}
		recSt[s] = false;
		return false;
	}
}