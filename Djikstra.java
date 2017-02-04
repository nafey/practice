public class Djikstra {
	private static final int MAX = 9999;
	
	private EWD graph;
	private int source;
	
	private double[] dist;
	private Dredge[] from;
	
	public Djikstra(EWD g, int s) {
		this.graph = g;
		this.source = s;
		
		Queue<Integer> q = new Queue<>();
		q.enqueue(s);
		
		dist = new double[g.V()];
		
		for (int i = 0; i < dist.length; i++) {
			this.dist[i] = MAX;
		}
		
		this.dist[s] = 0;
		
		from = new Dredge[g.V()];
		
		while (!q.isEmpty()) {
			Integer top = q.dequeue();
			double curr = dist[top];
			
			for (Dredge d : g.adj(top)) {
				if (curr + d.weight() < dist[d.to()]) {
					from[d.to()] = d;
					dist[d.to()] = curr + d.weight();
					
					q.enqueue(d.to());
				}
			}
			
		}
			
	}
	
	public double distTo(int v) {
		return dist[v];
	}
	
	public Iterable<Dredge> pathTo(int v) {
		return null;
	}
	
	public static void main(String[] args) {
		Djikstra dj = new Djikstra(Support.getEWD(), 0);
		
		System.out.println(dj.distTo(6));
	}
}