package designPatterns.objectPool;

import designPatterns.abstractFactory.AnimalFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pool<Animal> {

  private static Pool instance;
  private List<Animal> objects;
  private int capacity;
  private AnimalFactory factory;
  private ReentrantLock lock = new ReentrantLock();
  private Condition isEmpty = lock.newCondition();

  private Pool(AnimalFactory factory, String type, int C) {
    objects = new ArrayList<>();
    this.factory = factory;
    this.capacity = C;
    for (int i = 0; i < C; i++) {
      objects.add((Animal) factory.create(type));
    }
  }


  // factory
  public static Pool getInstance(AnimalFactory factory, String type, int C) {
    if (instance == null) {
      instance = new Pool(factory, type, C);
    }
    return instance;
  }

  public void addToPool(Animal animal) {
    objects.add(animal);
    if (objects.size() > 0) {
      isEmpty.signalAll();
    }
  }

  public Animal getFromPool() throws InterruptedException {
    Animal animal = null;
    lock.lock();
    try {
      if (objects.size() > 0) {
        animal = objects.get(objects.size() - 1);
        objects.remove(objects.size() - 1);
      }
      while (objects.size() == 0) {
        isEmpty.await();
      }

    } finally {
      lock.unlock();
    }
    return animal;
  }

}
