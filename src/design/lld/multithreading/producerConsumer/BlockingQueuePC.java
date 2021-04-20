package lld.multithreading.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuePC {

  static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

  public static void main(String[] args) throws InterruptedException {

    Runnable producerRunnable = new Runnable() {
      @Override
      public void run() {

        while (true) {
          try {
            queue.put(1);
          } catch (InterruptedException e) {
          }
        }
      }
    };

    new Thread(producerRunnable).start();
    new Thread(producerRunnable).start();

    Runnable consumerRunnable = new Runnable() {
      @Override
      public void run() {

        while (true) {
          try{
          queue.take();
        } catch (InterruptedException e) {
        }
        }
      }
    };

    new Thread(consumerRunnable).start();
    new Thread(consumerRunnable).start();


  }
}