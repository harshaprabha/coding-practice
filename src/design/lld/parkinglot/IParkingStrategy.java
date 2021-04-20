package lld.parkinglot;

import java.util.List;
import java.util.Optional;

public interface IParkingStrategy {

  Optional<List<Slot>> parkVehicle(Vehicle vehicle);
  void removeVehicle(Slot slot);

}
