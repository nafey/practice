public class Edge {
	private double weight;
	private int v;
	private int w;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return this.weight;
	}
	
	public int either() {
		return this.v;
	}
	
	public int other(int v) {
		if (v == this.v) {
			return w;
		}
		return v;
	}
	
	public int compareTo(Edge that) {
		if (this.weight > that.weight()) {
			return 1;
		} else if (this.weight == that.weight()) {
			return 0;
		} else {
			return -1;
		}
	}

	public String toString() {
		return this.v + "-----(" + this.weight + ")------" + this.w;
	}
	
	public static void main(String[] args) {
		Edge e = new Edge(1, 2, 0.345);
		
		
		System.out.println(e.toString());
	}
}
	