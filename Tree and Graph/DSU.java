 /*Time complexity
for m opearations
Simple implementation :  m*n
rank: m*log(n)
path compression : m*alpha(n)
where alpha(n)<=4
*/
import java.util.*;
public class DSU{
	int[] rank, parent;
	int n;
	//constructor
	public DSU(int n){
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSets();
	}
	//for making each node as a parent of itself
	void makeSets(){
		for(int i=0; i<n; i++){
			parent[i] = i;
		}
	}
	//find function using path compression
	int find(int x){
		if(parent[x]!=x){
			int super_parent = find(parent[x]);
			parent[x] = super_parent;
			return super_parent;
		}
		else
			return parent[x]; 
	}
	//Union function also using rank
	void union(int x, int y){
		int x_root = find(x);
		int y_root = find(y);

		if(x_root == y_root)
			return;

		if(rank[x_root]<rank[y_root]){
			parent[x_root] = y_root;
		}
		else if(rank[x_root]>rank[y_root])
			parent[y_root] = x_root;
		else{
			parent[y_root] = x_root;
			rank[x_root]++;
		}
	}
	public static void main(String[] args) {
		int n = 5; 
        DSU dus = new DSU(n); 
  
        // 0 is a friend of 2 
        dus.union(0, 2); 
  
        // 4 is a friend of 2 
        dus.union(4, 2); 
  
        // 3 is a friend of 1 
        dus.union(3, 1); 
  
        // Check if 4 is a friend of 0 
        if (dus.find(4) == dus.find(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
  
        // Check if 1 is a friend of 0 
        if (dus.find(1) == dus.find(0)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
	}
}