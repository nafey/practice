import java.lang.Iterable;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	public Node<T> head;
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void push(T val) {
		Node<T> n = new Node<>(val);
		n.next = head;
		head = n;
	}
	
	public T pop() {
		if (this.isEmpty()) return null;
		
		T ret = this.head.val;
		this.head = this.head.next;
		
		return ret;
	}
	
	public Iterator<T> iterator() {
		final Node<T> ll = head;
		return new Iterator<T>() {
			Node<T> l = ll;
			public boolean hasNext() {
				return (l != null);
			}
			
			public T next() {
				T ret = l.val;
				l = l.next;
				return ret;
			}
		};
	}
		
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(5);
		stack.push(51);
		stack.push(15);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		System.out.println("Hello Stack!");
	}
}