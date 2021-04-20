package lld.multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    CountDownLatch latch = new CountDownLatch(2);
    executorService.submit(new DependentTask(latch));
    executorService.submit(new DependentTask(latch));
    //executorService.submit(new DependentTask(latch));
    System.out.println(Thread.currentThread().getName() + "befor latch");
    latch.await();
    System.out.println(Thread.currentThread().getName() + "After latch");
    System.out.println("Done");
    executorService.shutdown();
  }

  static class DependentTask implements Runnable {

    private CountDownLatch latch;

    public DependentTask(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {

      }

      latch.countDown();

      // After latch count statemnet, these next lines can get printed anytime
      System.out.println(Thread.currentThread().getName() + "thread running");
      System.out.println("Service running");

    }
  }

}
