
public class RiderList implements IRiderList{
private Node<IRider> head;
private int size;

public RiderList() {
	head = null;
	size = 0;
}

public boolean add (IRider rider) {
	if(rider == null)
		return false;
	
	if(head == null || rider.compareTo(head.data) < 0) {
		Node<IRider> n = new Node<IRider>(rider);
		n.next = head;
		head = n;
		size++;
		return true;
	}
	
	if(rider.compareTo(head.data) == 0)
		return false;
	
	Node<IRider> current = head;
	while(current.next !=null && current.next.data.compareTo(rider)<0) {
		current = current.next;
	}
	
	if(current.next != null && current.next.data.compareTo(rider) == 0 )
		return false;
	
	Node<IRider> m = new Node<IRider>(rider);
	m.next= current.next;
	current.next = m;
	size++;
	return true;
			
}

public IRider findById(int riderId) {
   Node<IRider> p = head;
   while (p!= null) {
	if (p.data.getId() == riderId) {
    return p.data;
	}
	if(p.data.getId() > riderId)
		break;
	
	p = p.next;
}
   return null;
}

public LinkedList<IRider> findByName(String fullName) {
	LinkedList<IRider> result = new LinkedList<IRider>();
	Node<IRider> c = head;
	while (c!= null) {
	if (c.data.getName() != null && c.data.getName().equals(fullName)) {
		result.insert(c.data);
	}
	c = c.next;
	}
	return result;
}
public IRider findByEmail(String email) {
	if(email == null )
		return null;
	
    Node<IRider> k = head;
    while (k != null) {
        if (k.data.getEmail() != null && k.data.getEmail().equalsIgnoreCase(email))
            return k.data;
        k = k.next;
    }
    return null;
}

public LinkedList<IRider> findByHomeCity(String homeCity) {
    LinkedList<IRider> result = new LinkedList<IRider>();
    Node<IRider> p = head;
    while (p != null) {
        if (p.data.getHomeCity().equalsIgnoreCase(homeCity))
            result.insert(p.data);
        p = p.next;
    }
    return result;
}

public LinkedList<IRider> getAll() {
    LinkedList<IRider> result = new LinkedList<IRider>();
    Node<IRider> f = head;
    while (f != null) {
        result.insert(f.data);
        f = f.next;
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
    Node<IRider> u = head;
    while (u.next != null) {
        if (u.next.data.getId() == riderId) {
            u.next = u.next.next;
            size--;
            return true;
        }
        u = u.next;
    }
    return false;
}

public boolean removeByEmail(String email) {
    if (head == null || email == null)
        return false;
    
    if (head.data.getEmail() != null && head.data.getEmail().equalsIgnoreCase(email)) {
        head = head.next;
        size--;
        return true;
    }
    Node<IRider> r = head;
    while (r.next != null) {
        if (r.next.data.getEmail() != null && r.next.data.getEmail().equalsIgnoreCase(email)) {
            r.next = r.next.next;
            size--;
            return true;
        }
        r = r.next;
    }
    return false;
}

public int removeByName(String fullName) {
	if(head == null || fullName == null)
		return 0;
	
    int count = 0;
    while (head != null && fullName.equals(head.data.getName()) ) {
        head = head.next;
        count++;
    }
    Node<IRider> s = head;
    while (s != null && s.next != null) {
        if (fullName.equals( s.next.data.getName()) ) {
            s.next = s.next.next;
            count++;
        } else {
            s = s.next;
        }
    }
    size = size - count;
    return count;
}

public int removeByHomeCity(String homeCity) {
	if(head == null || homeCity == null)
		return 0;
	
    int count = 0;
    while (head != null && head.data.getHomeCity() != null && head.data.getHomeCity().equalsIgnoreCase(homeCity)) {
        head = head.next;
        count++;
    }
    Node<IRider> w = head;
    while (w != null && w.next != null) {
        if (w.next.data.getHomeCity() != null && w.next.data.getHomeCity().equalsIgnoreCase(homeCity)) {
            w.next = w.next.next;
            count++;
        } else {
            w = w.next;
        }
    }
    size = size - count;
    return count;
}

public int size() {
    return size;
}

}
