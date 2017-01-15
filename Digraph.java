
public class Digraph extends Graph {
	
	public Digraph(int i) {
		super(i);
	}
	
	protected void addEdge(Integer v, Integer w) {
		this.bags.get(v).add(w);
	}
		
		
	public static void main(String[] args) {
		Graph g = Support.getDigraph();
		System.out.println(g.connected(5, 0));
		
		System.out.println("Hello Digraph!");
	}
}