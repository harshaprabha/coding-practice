package lld.parkinglot;

public abstract class Slot {

  protected String slotId;
  protected int level;
  private final SlotType slotType;

  public String getSlotId() {
    return slotId;
  }

  protected SlotType getSlotType() {
    return slotType;
  }


  public Slot(SlotType type) {
    this.slotType = type;
  }


}
