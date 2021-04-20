package lld.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ParkingLot {

  private Map<Vehicle, List<Slot>> parkedSlotMap;
  private IParkingStrategy parkingStrategy;


  public ParkingLot(IParkingStrategy parkingStrategy) {
    this.parkingStrategy = parkingStrategy;
    parkedSlotMap = new HashMap<>();
    parkedSlotMap = new HashMap<>();
  }

  public void parkVehicle(Vehicle vehicle) {

    Optional<List<Slot>> slot = parkingStrategy.parkVehicle(vehicle);
    if (!slot.isPresent()) {
      throw new ParkingFullException("Parking is full");
    }
    parkedSlotMap.put(vehicle, slot.get());
  }


  public synchronized void removeVehicle(Vehicle vehicle) {
    for (Slot slot : parkedSlotMap.get(vehicle)) {
      parkingStrategy.removeVehicle(slot);
    }

  }


}
