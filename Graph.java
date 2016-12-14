import java.util.List;
import java.util.ArrayList;

public class Graph {
	
	private List<Bag<Integer>> bags;
	
	public Graph(int v) {
		bags = new ArrayList<Bag<Integer>>();
		
		for (int i = 0; i < v; i++) {
			bags.add(new Bag<Integer>());
		}
		
	}
	
	public void addEdge(Integer v, Integer w) {
		this.bags.get(v).add(w);
		this.bags.get(w).add(v);
	}
	
	public Iterable<Integer> adj(Integer v) {
		return bags.get(v);
	}
	
	public int V() {
		return this.bags.size();
	}
	
	public int E() {
		int c = 0;
		
		for (List list : bags) {
			c += list.size();
		}
		
		return c;
	}
		
		
	
	public static void main(String[] args) {
		Graph graph = new Graph(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		
		System.out.println("Hello Graph!");
	}
}