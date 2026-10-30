import java.util.*;

public class Person implements IPerson {
	private final int id;
	private String name;
	private String phoneNumber;
	private LinkedList<IRide> rideHistory;
	
	public Person(int id, String name, String phoneNumber) {
		this.id =id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		rideHistory = new LinkedList<IRide>();
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber.length() != 10 || phoneNumber == null) {
			throw new IllegalArgumentException("the phone must be exactly 10 numbers");
		}
		for(int i=0; i<10; i++) {
			char c = phoneNumber.charAt(i);
			if(c < '0' || c > '9') {
				throw new IllegalArgumentException("the phone number must be digits");
			}
		}
		this.phoneNumber =  phoneNumber;
	}

	public LinkedList<IRide> getRideHistory() {
		return rideHistory;
	}

	public String toString() {
		return "Person id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + "";
	}
	
	
	
	
}
