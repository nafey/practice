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
		
		for (Bag<Integer> bag : bags) {
			c += bag.size();
		}
		
		return c;
	}
		
	public boolean connected(int a1, int a2) {
		Bag<Integer> bag = bags.get(a1);
		
		for (Integer a: bag) {
			if (a2 == a) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Graph g = Support.getGraph();
		System.out.println(g.connected(5, 0));
		
		System.out.println("Hello Graph!");
	}
}