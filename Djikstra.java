public class Djikstra {
	private static final int MAX = 9999;
	
	private EWD graph;
	private int source;
	
	private double[] dist;
	private Dredge[] from;
	
	public Djikstra(EWD g, int s) {
		this.graph = g;
		this.source = s;
		
		dist = new double[g.V()];
		
		for (int i = 0; i < dist.length; i++) {
			this.dist[i] = MAX;
		}
		
		this.dist[s] = 0;
		
		from = new Dredge[g.V()];
		
		
		Queue<Integer> q = new Queue<>();
		q.enqueue(s);
		
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
	
	public Iterable<Integer> pathTo(int v) {
		Stack<Integer> stack = new Stack<>();
		
		int curr = v;
		stack.push(curr);
		
		while (curr != source) {
			curr = from[curr].from();
			stack.push(curr);
		}
		
		return stack;
	}
	
	public static void main(String[] args) {
		Djikstra dj = new Djikstra(Support.getEWD(), 0);
		Support.printList(dj.pathTo(6));
		
		System.out.println(dj.distTo(6));
	}
}