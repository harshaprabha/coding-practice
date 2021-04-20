package designPatterns.builder;

    import designPatterns.builder.User.UserBuilder;

public class Main {

  public static void main(String[] args) {
    User user = new UserBuilder(1, "harsha").address("testoptional").build();
  }
}
