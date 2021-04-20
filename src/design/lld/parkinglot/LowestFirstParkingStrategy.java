package lld.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class LowestFirstParkingStrategy implements IParkingStrategy {

  private TreeMap<String, CompactSlot> compactSlots;
  private TreeMap<String, RegularSlot> regularSlots;

  public LowestFirstParkingStrategy() {
    regularSlots = new TreeMap<>();
    compactSlots = new TreeMap<>();
  }

  void addSlots(Slot slot) {
    if (slot instanceof CompactSlot) {
      compactSlots.put(slot.getSlotId(), (CompactSlot) slot);
    } else {
      regularSlots.put(slot.getSlotId(), (RegularSlot) slot);
    }
  }

  @Override
  public synchronized Optional<List<Slot>> parkVehicle(Vehicle vehicle) {

    List<Slot> slots = new ArrayList<>();
    if (vehicle.getVehicleType().equals(VehicleType.VAN)) {
      if (regularSlots.size() >= 2) {
        slots.add(regularSlots.pollFirstEntry().getValue());
      }
    } else {
      if (compactSlots.size() >= 1) {
        slots.add(compactSlots.pollFirstEntry().getValue());
      }
    }

    if (!slots.isEmpty()) {
      return Optional.of(slots);
    }
    System.out.println("No slots");

    return Optional.ofNullable(null);

  }

  @Override
  public synchronized void removeVehicle(Slot slot) {

    if (slot instanceof CompactSlot) {
      compactSlots.put(slot.getSlotId(), (CompactSlot) slot);
    } else {
      compactSlots.put(slot.getSlotId(), (CompactSlot) slot);
    }

  }
}
