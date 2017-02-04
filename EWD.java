import java.util.List;
import java.util.ArrayList;

public class EWD {
	
	protected List<Bag<Dredge>> bags;
	
	public EWD(int v) {
		bags = new ArrayList<Bag<Dredge>>();
		
		for (int i = 0; i < v; i++) {
			bags.add(new Bag<Dredge>());
		}
	}
	
	public void addEdge(Dredge e) {
		this.bags.get(e.from()).add(e);
	}
	
	public int V() {
		return this.bags.size();
	}
	
	public int E() {
		int c = 0;
		
		for (Bag<Dredge> bag : bags) {
			c += bag.size();
		}
		
		return c;
	}
	
	public Iterable<Dredge> adj(int v) {
		return this.bags.get(v);
	}
	
	public Iterable<Dredge> edges() {
		List<Dredge> ret = new ArrayList<Dredge>();
		
		for (int i = 0; i < bags.size(); i++) {
			for (Dredge e : this.adj(i)) {
				ret.add(e);
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		EWD e = Support.getEWD();
		System.out.println("Hello EWD!");
	}
}