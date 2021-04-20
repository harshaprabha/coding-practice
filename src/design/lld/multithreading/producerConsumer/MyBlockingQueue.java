package lld.multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

  private Queue<E> queue;
  int N;
  private Lock lock = new ReentrantLock();
  private Condition notEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();

  public MyBlockingQueue(int N) {
    this.N = N;
    queue = new LinkedList<>();
  }

  void addElement(E e) throws InterruptedException {
    lock.lock();
    try {
      while (queue.size() == N) {
        notFull.await();
      }
      queue.add(e);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  E remove() throws InterruptedException {
    lock.lock();
    try {
      /**
       * while because when multiple threads are signalled, they will start waiting for lock after await() condition line.
       * if it was "IF", then one thread get lock and read from queue and make queue empty and then when next thread
       * comes it will get return for queue.remove()
       */

      while (queue.isEmpty()) {
        notEmpty.await();
      }
      E e = queue.remove();
      notFull.signalAll();
      return e;
    } finally {
      lock.unlock();
    }

  }

}
