import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
	
	// an iterator, doesn't implement remove() since it's optional
    private class ListIterator<I> implements Iterator<I> {
        private Node<I> current;

        public ListIterator(Node<I> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { }

        public I next() {
            I item = current.val;
            current = current.next; 
            return item;
        }
    }
	
	
	public Node<T> top;
	
	public void add(T val) {
		Node<T> n = new Node<T>(val);
		n.next = top;
		top = n;
	}
	
	public Iterator<T> iterator() {
		return new ListIterator<T>(top);
	}
	


	public static void main(String[] args) {
		Bag<Integer> b = new Bag<Integer>();
		b.add(1);
		b.add(2);
		b.add(3);
		
		for (Integer i : b) {
			System.out.println(i);
		}
		
		System.out.println("Hello Bag!");
	}
}