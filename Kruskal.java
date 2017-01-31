public class Kruskal {
	private EWG g;
	private Edge[] mst;
	private int mst_i = 0;;
	private Union union;
	
	public Kruskal(EWG g) {
		this.g = g;
		this.mst = new Edge[g.V() - 1];
		union = new Union(g.V());
		
		Heap<Edge> h = new Heap(false);
		
		for (Edge e : this.g.edges()) {
			h.add(e);
		}
		
		while (h.hasMore()){
			Edge e = h.top();
			if (!union.connected(e.either(), e.other(e.either()))){
				union.union(e.either(), e.other(e.either()));
				mst[mst_i] = e;
				mst_i++;
			}
		}
	}
	
	public Edge[] getMST() {
		return this.mst;
	}
	
	public static void main(String[] args) {
		Kruskal k = new Kruskal(Support.getEWG());
		
		Edge[] mst = k.getMST();
		for (Edge e : mst) {
			System.out.println(e.toString());
		}
		
		System.out.println("Hello World!");
	}
}