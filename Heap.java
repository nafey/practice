public class Heap<T extends Comparable> {
	private static final int MAX_SIZE = 100;
	private int tail;
	private Object[] vals; 
	private boolean isMax;
	
	public Heap(boolean isMax) {
		this.vals = new Object[MAX_SIZE];
		this.tail = 1;
		this.isMax = isMax;
	}
	
	void printHeap() {
		Support.printList(this.vals, this.tail);
	}
	
	private int getParent(int i) {
		return i / 2;
	}
	
	private int getChild1(int i) {
		int ret = i * 2;
		if (ret < MAX_SIZE && ret <= tail) {
			return ret;
		} else {
			return -1;
		}
	}
	
	private int getChild2(int i) {
		int ret = i * 2 + 1;
		if (ret < MAX_SIZE && ret <= tail) {
			return ret;
		} else {
			return -1;
		}
	}
	
	
		
		
	
	private void sink(int i) {
		if (i > MAX_SIZE || i >= tail) return;
		
		int c1 = this.getChild1(i);
		int c2 = this.getChild2(i);
		
		if (c1 == -1 || c2 == -1) {
			return;
		}
		
		if (!isAbove(((T) this.vals[i]), ((T) this.vals[c1])) || 
			!isAbove(((T) this.vals[i]), ((T) this.vals[c2]))){
			int c;
			if (isAbove(((T) this.vals[c1]), ((T) this.vals[c2]))) {
				c = c1;
			} else {
				c = c2;
			}
			
			T temp = ((T) this.vals[i]);
			vals[i] = this.vals[c];
			this.vals[c] = temp;
			
			this.sink(c);
		}
	}
	
	private void swim(int i) {
		if (i <= 1) return;
		
		if (isAbove(((T) vals[i]), ((T) vals[getParent(i)]))) {
			T temp = ((T) vals[i]);
			vals[i] = vals[getParent(i)];
			vals[getParent(i)] = temp;
		}
		
		swim(getParent(i));
	}
	
	private boolean isAbove(T a, T b) {
		boolean ret = (a.compareTo(b) >= 0);

		if (isMax) return ret;
		else return !ret;
	}
	
	public void add(T val) {
		this.vals[tail] = val;
		this.swim(tail);
		tail++;
	}
	
	public T top() {
		if (tail == 1) return null;
		T ret = ((T) this.vals[1]);
		
		this.vals[1] = this.vals[tail - 1];
		tail = tail - 1;
		
		this.sink(1);
		
		return ret;
	}
	
	public boolean hasMore() {
		if (tail == 1) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		Heap<Integer> h = new Heap(false);
		
		h.add(2);
		h.add(1);
		
		h.add(3);
		h.add(6);
		h.add(5);
		h.add(4);
		
		h.printHeap();
		
		System.out.println("The top is " + h.top());
		h.printHeap();
		
		System.out.println("The top is " + h.top());
		h.printHeap();
		
		System.out.println("The top is " + h.top());
		h.printHeap();
		
		System.out.println("The top is " + h.top());
		h.printHeap();
		
		System.out.println("The top is " + h.top());
		h.printHeap();
		
		System.out.println("The top is " + h.top());
		h.printHeap();
		
		System.out.println("Hello World!");
	}
}