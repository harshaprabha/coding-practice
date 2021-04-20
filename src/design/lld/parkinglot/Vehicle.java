package lld.parkinglot;


public abstract class Vehicle {

  private String number;

  private final VehicleType vehicleType;

  public Vehicle(VehicleType type) {
    vehicleType = type;
  }

  public VehicleType getVehicleType() {
     return this.vehicleType;
  }

}
