package javaBasics.generics;

public class UseAPair {

  String name;

  public static void main(String[] args) {

    ClothingPair<Glove> pair = new ClothingPair<>(new Glove(1, "RED"), new Glove(1, "RED"));
    if (pair.isMatched()) {
      System.out.println("matched");
    } else {
      System.out.println(" not a matched");
    }

    Pair<Integer> p = new Pair<>(1, 2);
    System.out.println(p.getKey());
    System.out.println(p.getValue());



    System.out.println(ClothingPair.<Glove>match(new Glove(1, "RED"), new GloveDupe(1,"")));
   // System.out.println(ClothingPair.<Glove>match(new Glove(1, "RED"), new GloveDupe(1,"")));

  }

}
