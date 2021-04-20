package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageServer implements Subject {

  private AtomicInteger counter = new AtomicInteger();
  private List<Observer> observerList;

  public MessageServer() {
    observerList = new ArrayList<>();
    counter = new AtomicInteger(0);
  }

  @Override
  public void addObserver(Observer observer) {
    this.observerList.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observerList.remove(observer);
  }

  @Override
  public void notifyObservers() {

    for (Observer ob : observerList) {
      ob.update(this, counter.addAndGet(10));
    }
  }

  void action() {
    notifyObservers();
  }

}
