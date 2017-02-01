public class Prim {
	private EWG ewg;
	private Edge[] edges;
	private int edges_i;
	private boolean[] marked;
	
	public Prim(EWG e) {
		this.ewg = e;
		this.edges = new Edge[e.V() - 1];
		this.marked = new boolean[e.V()];
		this.edges_i = 0;
		
		Heap<Edge> h = new Heap(false);
		for (Edge edge : ewg.adj(0)) {
			h.add(edge);
		}
		
		this.marked[0] = true;
		
		while (this.edges_i < this.ewg.V() - 1) {
			//Get smallest
			Edge small = h.top();
			
			if (!this.marked[small.either()]){
				for (Edge edge : this.ewg.adj(small.either())) {
					if (!this.marked[edge.other(small.either())]) {
						h.add(edge);
					}
				}
				
				this.marked[small.either()] = true;
				
				edges[edges_i] = small;
				
				edges_i++;
			} else if (!this.marked[small.other(small.either())]) {
				int other = small.other(small.either());
				
				for (Edge edge : this.ewg.adj(other)) {
					if (!this.marked[edge.other(other)]) {
						h.add(edge);
					}
				}
				
				this.marked[other] = true;
				
				edges[edges_i] = small;
				
				edges_i++;
			}
		}
	}
	
	public Edge[] getMST() {
		return this.edges;
	}
	
	public static void main(String[] args) {
		Prim p = new Prim(Support.getEWG());
		
		Edge[] mst = p.getMST();
		for (Edge e : mst) {
			System.out.println(e.toString());
		}
		
		System.out.println("Hello World!");
	}
}