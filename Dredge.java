public class Dredge {
	private int from;
	private int to;
	private double weight;
	
	public Dredge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int from() {
		return from;
	}
	
	public int to() {
		return to;
	}
	
	public double weight() {
		return weight;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	
}