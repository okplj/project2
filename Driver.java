
public class Driver extends Person implements IDriver {
	private String vehiclePlate;
    private VehicleType vehicleType;

    public Driver(int id, String name, String phoneNumber, String vehiclePlate, VehicleType vehicleType) {
        super(id, name, phoneNumber);
        setVehiclePlate(vehiclePlate);
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        if (vehiclePlate == null || vehiclePlate.length() != 7)
            throw new IllegalArgumentException("the plate must have exactly 7 characters");
        
        for (int i = 0; i < 3; i++) {
            char c = vehiclePlate.charAt(i);
            if (c < 'A' || c > 'Z')
                throw new IllegalArgumentException("the plate must start with 3 capital letters");
        }
        for (int i = 3; i < 7; i++) {
            char c = vehiclePlate.charAt(i);
            if (c < '0' || c > '9')
                throw new IllegalArgumentException("the plate must end with 4 digits");
        }
        this.vehiclePlate = vehiclePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int compareTo(IDriver other) {
        return Integer.compare(getId(),  other.getId());
    }

	public String toString() {
		return "Driver: "+ super.toString() +" ,vehiclePlate=" + vehiclePlate + ", vehicleType=" + vehicleType ;
	}

   
}
