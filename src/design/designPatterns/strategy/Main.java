package designPatterns.strategy;

import java.text.SimpleDateFormat;
import java.util.Stack;

public class Main {

  BaseAuth auth;

  Main(BaseAuth auth) {
    this.auth = auth;
  }


  public static void main(String[] args) {

    new Main(new OAuth()).makeCall("abc");
  }

  void makeCall(String type) {

  }
}

