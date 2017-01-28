
public class Digraph extends Graph {
	
	public Digraph(int i) {
		super(i);
	}
	
	protected void addEdge(Integer v, Integer w) {
		this.bags.get(v).add(w);
	}
	
	public Digraph getReverse() {
		Digraph graph = new Digraph(this.V());
		
		for (int i = 0; i < this.V(); i++) {
			for (Integer j : this.adj(i)) {
				graph.addEdge(j, i);
			}
		}
		
		return graph;
	}
		
		
	public static void main(String[] args) {
		Digraph g = Support.getDigraph().getReverse();
		Topology t = new Topology(g);
		
		System.out.println("Hello Digraph!");
	}
}