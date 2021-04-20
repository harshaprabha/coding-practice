package lld.scheduledExecutorService;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {

    ScheduledJobPool scheduledJobPool;
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    final long startTime = System.currentTimeMillis();

    Scheduler(ScheduledJobPool scheduledJobPool) throws InterruptedException {
        this.scheduledJobPool = scheduledJobPool;
        initializeScheduler();
    }

    void initializeScheduler() throws InterruptedException {
        while (true) {
            long currTime = System.currentTimeMillis();
            Optional<ScheduledJob> job = scheduledJobPool.getNextScheduledJob(currTime);
            if (job.isPresent()) {
                executorService.submit(job.get().runnable);
            } else
                Thread.sleep(1000);

        }//while end

    }

}





