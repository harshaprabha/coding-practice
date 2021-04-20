package designPatterns.builder;


public class User {

  // mandatory params
  private int id;
  private String name;

  private String address; // optional

  private User(UserBuilder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.address = builder.address;
  }

  //All getter, and NO setter to provde immutability
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  // static as can be accessed without creating object and this code is class property and not objects=> this will be the same
  static class UserBuilder implements Builder<User> {

    private int id;
    private String name;

    private String address = ""; // optional

    // Initialize mandatory param
    public UserBuilder(int id, String name) {
      this.id = id;
      this.name = name;
    }

    // Pizza toppings set it if only required
    public UserBuilder address(String add) {
      this.address = add;
      return this;

    }

    // Once built state of the object cannot be changed=> making object immutable
    @Override
    public User build() {
      User user = new User(this);
      return user;
    }


  }


}
