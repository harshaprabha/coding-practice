package lld.parkinglot;

public class RegularSlot extends Slot {

  public RegularSlot(String id, int level) {
    super(SlotType.REGULAR);
    this.slotId = id;
    this.level=level;
}
}
