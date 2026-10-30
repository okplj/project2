import java.util.*;

public class RiderList implements IRiderList{
private Node<IRider> head;
private int size;

public RiderList() {
	head = null;
	size = 0;
}

public boolean add (IRider rider) {
	
	if(head == null || rider.compareTo(head.data)<0) {
		Node<IRider> n = new Node<IRider>(rider);
		n.next = head;
		head = n;
		size++;
		return true;
	}
	Node<IRider> h = head;
	while(h.next !=null && h.next.data.compareTo(rider)<0) {
		h = h.next;
	}
	if(h.data.compareTo(rider) == 0 || (h.next != null && h.next.data.compareTo(rider) == 0) )
		return false;
	
	Node<IRider> m = new Node<IRider>(rider);
	m.next= h.next;
	h.next = m;
	size++;
	return true;
			
}

public IRider findById(int riderId) {
   Node<IRider> p = head;
   while (p!= null) {
	if (p.data.getId() == riderId) {
    return p.data;
	}
	p = p.next;
}
   return null;
}

public LinkedList<IRider> findByName(String fullName) {
	LinkedList<IRider> result = new LinkedList<IRider>();
	Node<IRider> p = head;
	while (p!= null) {
	if (p.data.getName().equals(fullName)) {
		result.add(p.data);
	}
	p = p.next;
	}
	return result;
}
public IRider findByEmail(String email) {
    Node<IRider> p = head;
    while (p != null) {
        if (p.data.getEmail().equalsIgnoreCase(email))
            return p.data;
        p = p.next;
    }
    return null;
}

public LinkedList<IRider> findByHomeCity(String homeCity) {
    LinkedList<IRider> result = new LinkedList<IRider>();
    Node<IRider> p = head;
    while (p != null) {
        if (p.data.getHomeCity().equalsIgnoreCase(homeCity))
            result.add(p.data);
        p = p.next;
    }
    return result;
}

public LinkedList<IRider> getAll() {
    LinkedList<IRider> result = new LinkedList<IRider>();
    Node<IRider> p = head;
    while (p != null) {
        result.add(p.data);
        p = p.next;
    }
    return result;
}

public boolean removeById(int riderId) {
    if (head == null)
        return false;
    if (head.data.getId() == riderId) {
        head = head.next;
        size--;
        return true;
    }
    Node<IRider> p = head;
    while (p.next != null) {
        if (p.next.data.getId() == riderId) {
            p.next = p.next.next;
            size--;
            return true;
        }
        p = p.next;
    }
    return false;
}

public boolean removeByEmail(String email) {
    if (head == null)
        return false;
    if (head.data.getEmail().equalsIgnoreCase(email)) {
        head = head.next;
        size--;
        return true;
    }
    Node<IRider> p = head;
    while (p.next != null) {
        if (p.next.data.getEmail().equalsIgnoreCase(email)) {
            p.next = p.next.next;
            size--;
            return true;
        }
        p = p.next;
    }
    return false;
}

public int removeByName(String fullName) {
    int count = 0;
    while (head != null && head.data.getName().equals(fullName)) {
        head = head.next;
        count++;
    }
    Node<IRider> p = head;
    while (p != null && p.next != null) {
        if (p.next.data.getName().equals(fullName)) {
            p.next = p.next.next;
            count++;
        } else {
            p = p.next;
        }
    }
    size = size - count;
    return count;
}

public int removeByHomeCity(String homeCity) {
    int count = 0;
    while (head != null && head.data.getHomeCity().equalsIgnoreCase(homeCity)) {
        head = head.next;
        count++;
    }
    Node<IRider> p = head;
    while (p != null && p.next != null) {
        if (p.next.data.getHomeCity().equalsIgnoreCase(homeCity)) {
            p.next = p.next.next;
            count++;
        } else {
            p = p.next;
        }
    }
    size = size - count;
    return count;
}

public int size() {
    return size;
}

}
