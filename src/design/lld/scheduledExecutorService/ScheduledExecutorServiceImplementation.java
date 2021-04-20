package lld.scheduledExecutorService;

import problems.comparisons.OneHandSchedulingWithComparable;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class ScheduledExecutorServiceImplementation implements ScheduledExecutorService {

    ScheduledJobPool schedulerJobPool;

    ScheduledExecutorServiceImplementation(ScheduledJobPool schedulerJobPool) {
        this.schedulerJobPool = schedulerJobPool;
    }

    @Override
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        schedulerJobPool.addJob(new ScheduledJob(command, System.currentTimeMillis() + delay));
    }

    @Override
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {

    }

    @Override
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {

    }
}
