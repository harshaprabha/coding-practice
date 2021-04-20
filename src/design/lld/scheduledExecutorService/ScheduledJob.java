package lld.scheduledExecutorService;

public class ScheduledJob {
    Runnable runnable;
    long startTime;

    public ScheduledJob(Runnable runnable, long startTime) {
        this.runnable = runnable;
        this.startTime = startTime;
    }
}
