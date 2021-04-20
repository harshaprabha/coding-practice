package java.immutable;

import java.util.Date;

// final - cant be subclasses and subclasses cant access parent fields
public final class ImmutableClass {

  // private as outside class nobody can access this
  // final as value cannot be changed even accidently
  private final Integer val;
  private final Date date;

  // making constructor private so only method inside this class can create object and no other unplanned calls come
  // constructor cannot be final
  private ImmutableClass(Integer v, Date date) {
    this.val = 0;
    this.date = new Date(date.getTime());
  }

  // Factory method to create object - one place solution
  public static ImmutableClass getImmutableInstance(Integer val, Date date) {
    return new ImmutableClass(val,
        date); // make sure date is a fresh object as Date provides methods to change it
  }

  // Create new object of Class and then share
  public Date getDate() {
    return new Date(date.getTime());
  }

  public Integer getVal() {
    return val;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
