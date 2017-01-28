import java.util.List;
import java.util.ArrayList;

public class EWG {
	private List<Bag<Edge>> bags;
	
	public EWG(int v) {
		bags = new ArrayList<Bag<Edge>>();
		
		for (int i = 0; i < v; i++) {
			bags.add(new Bag<Edge>());
		}
	}
	
	public void addEdge(Edge e) {
		this.bags.get(e.either()).add(e);
		this.bags.get(e.other(e.either())).add(e);
	}
	
	public int V() {
		return this.bags.size();
	}
	
	public int E() {
		int c = 0;
		
		for (Bag<Edge> bag : bags) {
			c += bag.size();
		}
		
		return c;
	}
	
	public Iterable<Edge> adj(int v) {
		return this.bags.get(v);
	}
	
	public Iterable<Edge> edges() {
		List<Edge> ret = new ArrayList<Edge>();
		
		for (int i = 0; i < bags.size(); i++) {
			for (Edge e : this.adj(i)) {
				if (i == e.either()) {
					ret.add(e);
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		EWG e = Support.getEWG();
		System.out.println("Hello World!");
	}
}
	