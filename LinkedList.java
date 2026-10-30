
	public class LinkedList<T> {
	    private Node<T> head;
	    private Node<T> current;
	    private int size;

	    public LinkedList() {
	        head = current = null;
	        size = 0;
	    }

	    public boolean empty() {
	        return head == null;
	    }

	    public boolean last() {
	        return current != null && current.next == null;
	    }

	    public boolean full() {
	        return false;
	    }

	    public void findFirst() {
	        current = head;
	    }

	    public void findNext() {
	        if (current != null) {
	            current = current.next;
	        }
	    }

	    public T retrieve() {
	        return (current != null) ? current.data : null;
	    }

	    public void update(T val) {
	        if (current != null) {
	            current.data = val;
	        }
	    }

	    public void insert(T val) {
	        Node<T> tmp;
	        if (empty()) {
	            current = head = new Node<T>(val);
	        } else {
	            tmp = current.next;
	            current.next = new Node<T>(val);
	            current = current.next;
	            current.next = tmp;
	        }
	        size++;
	    }

	    public void remove() {
	        if (current == head) {
	            head = head.next;
	        } else {
	            Node<T> tmp = head;
	            while (tmp != null && tmp.next != current) {
	                tmp = tmp.next;
	            }
	            if (tmp != null) {
	                tmp.next = current.next;
	            }
	        }
	        if (current != null) {
	            if (current.next == null) {
	                current = head;
	            } else {
	                current = current.next;
	            }
	            size--;
	        }
	    }

	    public int size() {
	        return size;
	    }
	}

